package com.tzg.xhd.tbooking.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.tzg.xhd.tbooking.config.AlipayConfig;
import com.tzg.xhd.tbooking.entity.House;
import com.tzg.xhd.tbooking.service.HouseService;
import com.tzg.xhd.tbooking.util.DateUtil;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tzg.xhd.eastnan.service.HotelService;
import com.tzg.xhd.eastnan.entity.Hotel;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


@Api(description = "住宿")
@Slf4j
@Controller("houseController")
@RequestMapping(value = "/house")
public class HouseController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HouseService houseService;

    @ApiOperation(value = "住宿页面", notes = "展示酒店列表的页面")
    @RequestMapping(value = "/liveDetail",method = RequestMethod.GET)
    public String liveDetail(Model model, String roomAmount, String city, String priceMin, String priceMax){
        try{
            List<Hotel> hotelList = hotelService.selectHotel(roomAmount, city, priceMin, priceMax);
            model.addAttribute("hotelList",hotelList);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return "house/rooms";
    }

    @ApiOperation(value = "住宿信息录入页面", notes = "用户选择酒店后录入住宿信息")
    @RequestMapping(value = "/roomerDetail",method = RequestMethod.GET)
    public String roomerDetail(Model model, String id){
        try{
            Hotel hotel = hotelService.selectById(Integer.parseInt(id));
            model.addAttribute("hotel",hotel);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return "house/roomerDetail";
    }

    /**
     * 住宿支付接口
     * @param houseId     酒店id
     * @param roomDays    住几天
     * @param roomAmount  房间数
     * @param roomTimeStr 入住时间
     * @param rep
     */
    @ApiOperation(value = "住宿支付接口", notes = "调动支付宝的支付接口")
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public void pay(String houseId, String roomDays, String roomAmount, String roomTimeStr,HttpServletResponse rep){
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //付款时先在海胆系统内插入一条记录
        try {
        roomTimeStr = roomTimeStr.replace("T"," ");
        House house = new House();
        house.setHouseId(Integer.parseInt(houseId));
        house.setRoomDays(Integer.parseInt(roomDays));
        house.setRoomAmount(Integer.parseInt(roomAmount));
        house.setRoomTime(DateUtil.getDate(roomTimeStr,"yyyy-MM-dd HH:mm"));
        Hotel hotel = hotelService.selectById(house.getHouseId());
        house.setReadyPay(hotel.getPrePay().intValue());
        int all = Integer.parseInt(roomDays)*Integer.parseInt(roomAmount)*hotel.getPrice().intValue();
        house.setLastPay(all);
        house.setOrderNo(DateUtil.getCurrentTimeStamp());
        house.setUserId(HttpSessionUtil.getLoginUserSession().getId());
        house.setCreateTime(new Date());
        houseService.save(house);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "H"+house.getOrderNo()+house.getId();
        //付款金额，必填
        String total_amount = house.getLastPay().toString();
        //必填参数 （逻辑上没用）
        String subject = house.getHouseId().toString();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            rep.setContentType("text/html;charset=" + AlipayConfig.charset);
            rep.getWriter().write(result);
            rep.getWriter().flush();
            rep.getWriter().close();
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @ApiIgnore
    @RequestMapping(value = "/houseDetail",method = RequestMethod.GET)
    public String houseDetail(Model model, String houseId){
        House house = houseService.findById(Integer.parseInt(houseId));
        model.addAttribute("house",house);
        return "house/recordDetail";
    }

}
