package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "首页")
@Controller("indexController")
public class IndexController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(Model model){
        User user = HttpSessionUtil.getLoginUserSession();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/ifLogin",method = RequestMethod.GET)
    @ResponseBody
    public boolean ifLogin(){
        User user = HttpSessionUtil.getLoginUserSession();
        if(null != user){
            return true;
        }
        return false;
    }
}
