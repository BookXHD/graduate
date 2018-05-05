package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.AnswerGenerator;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(description = "首页")
@Slf4j
@Controller("indexController")
public class IndexController {
    @ApiOperation(value = "主页", notes = "跳转主页 攻略页面")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(Model model){
        User user = HttpSessionUtil.getLoginUserSession();
        model.addAttribute("user", user);
        return "index";
    }

    @ApiOperation(value = "是否登录", notes = "判断用户是否登录 返回true/false")
    @RequestMapping(value = "/ifLogin",method = RequestMethod.GET)
    @ResponseBody
    public boolean ifLogin(){
        User user = HttpSessionUtil.getLoginUserSession();
        if(null != user){
            return true;
        }
        return false;
    }

    @ApiOperation(value = "用户详情", notes = "返回用户个人的详情")
    @RequestMapping(value = "/userDetail ",method = RequestMethod.POST)
    @ResponseBody
    public Answer getUserDetail(){
        Answer answer = new Answer();
        User user = HttpSessionUtil.getLoginUserSession();
        if(null != user){
            answer = AnswerGenerator.genFailAnswer("用户未登录");
        }
        answer = AnswerGenerator.genSuccessAnswer(user);
        return answer;
    }

}
