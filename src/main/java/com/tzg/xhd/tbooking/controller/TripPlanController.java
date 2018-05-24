package com.tzg.xhd.tbooking.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.tzg.xhd.tbooking.VO.TripPlanVO;
import com.tzg.xhd.tbooking.VO.TripTipsVO;
import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.AnswerGenerator;
import com.tzg.xhd.tbooking.config.AlipayConfig;
import com.tzg.xhd.tbooking.entity.*;
import com.tzg.xhd.tbooking.service.*;
import com.tzg.xhd.tbooking.util.DateUtil;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import com.tzg.xhd.tbooking.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@Api(description = "旅游套餐")
@Slf4j
@Controller("tripPlanController")
@RequestMapping(value = "/tripPlan")
public class TripPlanController {
    @Autowired
    private TripPlanService tripPlanService;

    @Autowired
    private TripPlanOrderService tripPlanOrderService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TripTipsService tripTipsService;

    @Autowired
    private SpotTicketService spotTicketService;

    @ApiOperation(value = "旅游套餐收藏接口", notes = "收藏旅游套餐")
    @RequestMapping(value = "/collectPlanSave",method = RequestMethod.GET)
    @ResponseBody
    public Answer collectPlanSave(String planId, String person){
        Answer answer = new Answer();
        User user = HttpSessionUtil.getLoginUserSession();
        if(null == user) {
            return AnswerGenerator.genFailAnswer("请先登录！");
        }
        try{
            tripPlanOrderService.CreateOrderByCollect(planId, person);
            answer = AnswerGenerator.genSuccessAnswer("收藏成功！");
        }catch (Exception e){
            log.error(e.getMessage());
            return AnswerGenerator.genFailAnswer("收藏出错！");
        }
        return answer;
    }

    @ApiOperation(value = "旅游套餐支付接口", notes = "支付旅游套餐")
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public void pay(HttpServletResponse rep,String planId,String person){
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        TripPlan tripPlan = tripPlanService.findById(Integer.parseInt(planId));

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "T"+DateUtil.getCurrentTimeStamp()+planId;
        //如果人数没有输入，则默认为1
        if(StringUtils.isBlank(person)){
            person = "1";
        }
        //付款金额，必填
        Double all = tripPlan.getPrice().doubleValue() * Double.parseDouble(person);
        String total_amount = all.toString();
        //必填参数 （逻辑上没用）
        String subject = tripPlan.getId().toString();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        try {
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            rep.setContentType("text/html;charset=" + AlipayConfig.charset);
            rep.getWriter().write(result);
            rep.getWriter().flush();
            rep.getWriter().close();
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @ApiOperation(value = "支付宝同步返回接口", notes = "支付宝同步返回")
    @RequestMapping(value = "/payed",method = RequestMethod.GET)
    public String payed(HttpServletRequest request){
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        String orderNo = "";
        try {
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }
            //调用SDK验证签名
            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            if(signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
                orderNo = out_trade_no;
            }else {
                throw new Exception("验签失败！");
            }
        }catch (Exception e){
            log.error("错误日志测试"+e.getMessage());
        }

        //跳转到页面跳转接口
        return "redirect:/tripPlan/queryOrder?orderNo=" + orderNo;
        //跳转到数据返回接口
//        return "redirect:/tripPlan/queryOrderForm?orderNo=" + orderNo;
    }

    @ApiIgnore()
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail(String planId, Model model){
        try {
            TripPlan tripPlan = tripPlanService.findById(Integer.parseInt(planId));
            String planRoute = tripPlan.getPlanRoute();
            planRoute = planRoute.replace(","," -> ");
            String[] daysPlan = planRoute.split(";");
            String amountStr = RedisUtil.getKey("tripPlan"+planId);
            if(StringUtils.isBlank(amountStr)) {
                amountStr = "0";
            }
            int amount = Integer.valueOf(amountStr).intValue();
            amount++;
            RedisUtil.setKey("tripPlan"+planId,new Integer(amount).toString());
            model.addAttribute("tripPlan", tripPlan);
            model.addAttribute("daysPlan", daysPlan);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "tripPlan/detail";
    }

    @ApiOperation(value = "旅游路线详情页面", notes = "点击旅游路线之后跳出来的旅游路线详情页面")
    @RequestMapping(value = "/tripPlanDetail",method = RequestMethod.GET)
    @ResponseBody
    public Answer tripPlanDeatail(String id) {
        Answer answer = new Answer();
        try {
            TripPlan tripPlan = tripPlanService.findById(Integer.parseInt(id));
            City city = cityService.findById(tripPlan.getCityId());
            List<TripTipsVO> tripTipsVOS = tripTipsService.getTripTipsList(city.getId(),tripPlan.getDays());
            //点击详情增加 浏览次数
            String amountStr = RedisUtil.getKey("tripPlan"+id);
            if(StringUtils.isBlank(amountStr)) {
                amountStr = "0";
            }
            int amount = Integer.valueOf(amountStr).intValue();
            amount++;
            RedisUtil.setKey("tripPlan"+id,new Integer(amount).toString());
            Map<String,Object> map = new HashMap<>();
            map.put("city",city);
            map.put("tripPlan", tripPlan);
            map.put("tripTips", tripTipsVOS);
            map.put("viewCount",new Integer(amount).toString());
            answer = AnswerGenerator.genSuccessAnswer(map);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("旅游路线详情页面后台请求出错！");
        }
        return answer;
    }

    @ApiOperation(value = "景点门票攻略", notes = "通过旅游攻略的id获取改攻略下的景点门票攻略")
    @RequestMapping(value = "/spotTicket",method = RequestMethod.GET)
    @ResponseBody
    public Answer spotTicket(String id) {
        Answer answer = new Answer();
        try {
            SpotTicket spotTicket = new SpotTicket();
            spotTicket.setTripTipsId(Integer.parseInt(id));
            List<SpotTicket> spotTickets = spotTicketService.findByModel(spotTicket);
            answer = AnswerGenerator.genSuccessAnswer(spotTickets);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("旅游路线详情页面后台请求出错！");
        }
        return answer;
    }

    @ApiOperation(value = "查询支付宝订单接口", notes = "查询支付宝订单接口 ")
    @RequestMapping(value = "/queryOrder",method = RequestMethod.GET)
    public String queryOrder(String orderNo) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = orderNo;
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"}");
        try {
            //请求
            String result = alipayClient.execute(alipayRequest).getBody();
            Map map1 = (Map)JSONObject.parseObject(result);
            Map a = (Map)map1.get("alipay_trade_query_response");
            String tradeAtatus = a.get("trade_status").toString();
            String totalAmount = a.get("total_amount").toString();
            //假如此条订单返回 “查询成功” 则进行业务逻辑
            if(out_trade_no.indexOf("T")>=0 && tradeAtatus.equals("TRADE_SUCCESS")) {
                out_trade_no = out_trade_no.substring(1,out_trade_no.length());
                //没收藏直接购买的
                String planId = out_trade_no.substring(14, out_trade_no.length());
                tripPlanOrderService.CreateOrderByBought(planId, out_trade_no, totalAmount);
                //在个人订单管理中通过收藏购买的

            }else if(out_trade_no.indexOf("H")>=0) {
                out_trade_no = out_trade_no.substring(1,out_trade_no.length());
                String houseId = out_trade_no.substring(14, out_trade_no.length());
                if(tradeAtatus.equals("TRADE_SUCCESS")){
                    //如果交易成功,则把海胆系统的交易记录数据同步到东南向系统
                    houseService.order(houseService.findById(Integer.parseInt(houseId)));
                } else {
                    //如果交易不成功,则把海胆系统中的交易记录数据删除掉（回退）
                    houseService.deleteById(Integer.parseInt(houseId));
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "redirect:http://localhost:8082/myorder";
    }

    @ApiIgnore
    @RequestMapping(value = "/queryOrderForm",method = RequestMethod.GET)
    public Answer queryOrderForm(String orderNo) {
        Answer answer = new Answer();
        Map<String,Object> map = new HashMap<>();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = orderNo;
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"}");
        try {
            //请求
            String result = alipayClient.execute(alipayRequest).getBody();
            Map map1 = (Map)JSONObject.parseObject(result);
            Map a = (Map)map1.get("alipay_trade_query_response");
            String tradeAtatus = a.get("trade_status").toString();
            String totalAmount = a.get("total_amount").toString();
            //假如此条订单返回 “查询成功” 则进行业务逻辑
            if(out_trade_no.indexOf("T")>=0 && tradeAtatus.equals("TRADE_SUCCESS")) {
                //T 开头的为旅游路线
                out_trade_no = out_trade_no.substring(1,out_trade_no.length());
                //没收藏直接购买的
                String planId = out_trade_no.substring(14, out_trade_no.length());
                tripPlanOrderService.CreateOrderByBought(planId, out_trade_no, totalAmount);
                //在个人订单管理中通过收藏购买的

            }else if(out_trade_no.indexOf("H")>=0) {
                //H 开头的为酒店
                out_trade_no = out_trade_no.substring(1,out_trade_no.length());
                String houseId = out_trade_no.substring(14, out_trade_no.length());
                if(tradeAtatus.equals("TRADE_SUCCESS")){
                    //如果交易成功,则把海胆系统的交易记录数据同步到东南向系统
                    houseService.order(houseService.findById(Integer.parseInt(houseId)));
                    map.put("TRADE_SUCCESS",true);
                } else {
                    //如果交易不成功,则把海胆系统中的交易记录数据删除掉（回退）
                    houseService.deleteById(Integer.parseInt(houseId));
                    map.put("TRADE_SUCCESS",false);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("查询支付宝订单接口后台出错");
        }
        return answer;
    }



    @ApiOperation(value = "攻略查询", notes = "返回攻略的右模糊查询结果")
    @RequestMapping(value = "/queryTripTips",method = RequestMethod.GET)
    @ResponseBody
    public Answer queryTripTips(String tripPlanName){
        Answer answer = new Answer();
        try {
            List<TripPlan> tripPlans = tripPlanService.getTripPlanByName(tripPlanName);
            answer = AnswerGenerator.genSuccessAnswer(tripPlans);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("攻略查询 后台请求出错！");
        }
        return answer;
    }

    @ApiOperation(value = "点赞", notes = "点赞")
    @RequestMapping(value = "/diadnzan",method = RequestMethod.GET)
    @ResponseBody
    public Answer diadnzan(){
        Answer answer = new Answer();
        User user = HttpSessionUtil.getLoginUserSession();
        String amountStr1 = "";
        try {
            //点赞
            String amountStr = RedisUtil.getKey("dianzan"+user.getId());
            if(StringUtils.isBlank(amountStr)) {
                amountStr1 = RedisUtil.getKey("dianzan");
            }
            int amount = Integer.valueOf(amountStr1).intValue();
            amount++;
            RedisUtil.setKey("dianzan",new Integer(amount).toString());
            RedisUtil.setKey("dianzan"+user.getId(),"1");
            answer = AnswerGenerator.genSuccessAnswer(amount);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("攻略查询 后台请求出错！");
        }
        return answer;
    }
}
