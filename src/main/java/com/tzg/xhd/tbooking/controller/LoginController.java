package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.entity.Login;
import com.tzg.xhd.tbooking.mapper.LoginMapper;
import com.tzg.xhd.tbooking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller("LoginController")
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * @return 登录页面
     */
    @RequestMapping(value = "/login")
    public String Index(){
        return "login";
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public Answer check(String loginName,String password){
        Answer<Login> answer = loginService.findUser(loginName);
        Login login = answer.getData();
        if(null != login) {
            if (login.getPassword().equals(password)) {
                answer.setSuccess(true);
            } else {
                answer.setSuccess(false);
                answer.setMessage("密码错误！");
            }
        }
        return answer;
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "/register";
    }

    public String getWww() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
