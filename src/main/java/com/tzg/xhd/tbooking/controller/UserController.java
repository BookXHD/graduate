package com.tzg.xhd.tbooking.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tzg.xhd.eastnan.entity.Hotel;
import com.tzg.xhd.eastnan.service.HotelService;
import com.tzg.xhd.tbooking.VO.HotelRecordVO;
import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.AnswerGenerator;
import com.tzg.xhd.tbooking.entity.House;
import com.tzg.xhd.tbooking.entity.TripPlanOrder;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.service.HouseService;
import com.tzg.xhd.tbooking.service.TripPlanOrderService;
import com.tzg.xhd.tbooking.service.UserService;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j    .Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(description = "用户操作")
@Slf4j
@Controller("userController")
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    TripPlanOrderService tripPlanOrderService;

    @Autowired
    HouseService houseService;

    @Autowired
    HotelService hotelService;

    @ApiOperation(value = "用户登录页面", notes = "用户登录页面跳转")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Index(){
        return "user/login";
    }

    @RequestMapping(value = "/testLogin",method = RequestMethod.GET)
    public void testLogin() {
        User user = new User();
        user.setLoginName("root");
        user.setPassword("111");
        HttpSessionUtil.setLoginUserSession(user);
    }

    @ApiOperation(value = "用户检测接口", notes = "检测用户是否已注册 以及密码是否正确")
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name="loginName",value="用户名",dataType="String", paramType = "query",required = true),
            @ApiImplicitParam(name="password",value="密码",dataType="String", paramType = "query",required = true)})
    public Answer check(String loginName, String password){
        Answer<User> answer = userService.findUser(loginName);
        User user = answer.getData();
        if(null != user){
            if (!user.getPassword().equals(password)) {
                return AnswerGenerator.genFailAnswer("密码错误！");
            } else {
                HttpSessionUtil.setLoginUserSession(user);
            }
        }
        return answer;
    }

    @ApiOperation(value = "用户退出接口", notes = "用户退出")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Answer logout(){
        HttpSessionUtil.setLoginUserSession(null);
        return AnswerGenerator.genSuccessAnswer("已退出");
    }

    @ApiOperation(value = "注册用户页面", notes = "注册用户页面跳转")
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "user/register";
    }

    @ApiOperation(value = "用户注册接口", notes = "新增用户 不可重复已存在的用户名")
    @RequestMapping(value = "/registerSave",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParam(name = "user",value = "用户实体类",dataType = "User",paramType = "body",required = true)
    public Answer newUser(@RequestBody @Valid User user, BindingResult result){
        Answer answer = new Answer();
        try {
            if(result.hasErrors()){
                List<ObjectError> errorList = result.getAllErrors();
                String message = "";
                for (ObjectError error : errorList){
                    message += error.getDefaultMessage();
                }
                return AnswerGenerator.genFailAnswer(message);
            }
            user.setPicture("white.png");
            answer = userService.saveUser(user);
        }catch (Exception e){
            answer = AnswerGenerator.genFailAnswer(e.getMessage());
            logger.error("注册 业务层错误",e);
        }
        return answer;
    }

    @ApiOperation(value = "用户中心页面", notes = "用户中心页面跳转")
    @RequestMapping(value = "/userCenter",method = RequestMethod.GET)
    public String userCenter(Model model){
        User user = HttpSessionUtil.getLoginUserSession();
        model.addAttribute("user", user);
        return "user/center";
    }

    @ApiOperation(value = "用户信息编辑", notes = "用户信息编辑页面跳转")
    @RequestMapping(value = "/editInformation",method = RequestMethod.GET)
    public String editInformation(Model model){
        User user = HttpSessionUtil.getLoginUserSession();
        model.addAttribute("user", user);
        return "user/editInformation";
    }

    @ApiOperation(value = "用户信息编辑接口", notes = "用户信息编辑功能")
    @RequestMapping(value = "/editInformationverify",method = RequestMethod.POST)
    @ResponseBody
    public Answer editInformationverify(@RequestBody User user){
        userService.update(user);
        HttpSessionUtil.setLoginUserSession(userService.findById(user.getId()));
        return AnswerGenerator.genSuccessAnswer("编辑成功！",user);
    }

    @ApiOperation(value = "头像上传接口", notes = "头像上传功能")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Answer upload(@RequestParam("picture")MultipartFile multipartFile, HttpServletRequest request){
        //处理上传文件
        String oldFileName = multipartFile.getOriginalFilename();
        //request.getServletContext() --> application
        String uploadPath ="D:\\MyDrivers\\software\\tomcat\\tom8\\webapps\\img";
        //上传文件 java.io.File
        File targetFile = new File(uploadPath,oldFileName);
        try {
            multipartFile.transferTo(targetFile);
        } catch (IOException e) {
            logger.info(e.getMessage());
            return AnswerGenerator.genFailAnswer(e.getMessage());
        } catch (IllegalStateException e) {
            logger.info(e.getMessage());
            return AnswerGenerator.genFailAnswer(e.getMessage());
        }
        User user = HttpSessionUtil.getLoginUserSession();
        if(null == user){
            return AnswerGenerator.genFailAnswer("用户session已过期,请重新登录");
        }
        user.setPicture(oldFileName);
        userService.update(user);
        HttpSessionUtil.setLoginUserSession(user);
        return AnswerGenerator.genSuccessAnswer("上传成功!");
    }

    @ApiIgnore()
    @RequestMapping(value = "/orderRecord",method = RequestMethod.GET)
    public String orderRecord(Model model){
        User user = HttpSessionUtil.getLoginUserSession();
        List<TripPlanOrder> tripPlanOrders = tripPlanOrderService.selectByUser(user.getId());
        List<HotelRecordVO> houses = houseService.selectByUser(user.getId().toString(),null);
        model.addAttribute("houses",houses);
        model.addAttribute("tripPlanOrders",tripPlanOrders);
        return "user/order";
    }

    /**
     * 异步获取订单
     * @param currentPage 当前页
     * @return
     */
    @ApiOperation(value = "订单管理页面", notes = "管理用户酒店和旅游套餐的订单")
    @RequestMapping(value = "/orderMange",method = RequestMethod.GET)
    @ResponseBody
    public Answer orderMange(String currentPage,String houseName) {
        Answer answer = new Answer();
        Map<String,Object> map = new HashMap<>();
        int pageSize = 8;
        try {
            int pageNum = Integer.parseInt(currentPage);
            PageHelper.startPage(pageNum, pageSize);
            User user = HttpSessionUtil.getLoginUserSession();
            if(null == user){
                return AnswerGenerator.genFailAnswer("用户session已过期,请重新登录");
            }
            List<Hotel> hotels = hotelService.selectHotel(null,null,null,null,houseName);
            String houseId = "";
            if(hotels.size() == 1){
                Hotel hotel = hotels.get(0);
                houseId = hotel.getId().toString();
            }
            List<HotelRecordVO> houses = houseService.selectByUser(user.getId().toString(),houseId);
            map.put("pageSize",pageSize);
            map.put("totalPage",houseService.selectOrderCount(user.getId().toString(),houseId));
            map.put("orderRecord",houses);
            answer = AnswerGenerator.genSuccessAnswer(map);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("订单管理页面后台请求出错！");
        }
        return answer;
    }

    private String getWww() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
