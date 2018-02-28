package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.AnswerGenerator;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Api(description = "用户操作")
@Controller("LoginController")
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * @return 登录页面
     */
    @ApiIgnore()
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Index(){
        return "login";
    }

    @ApiOperation(value = "用户检测", notes = "检测用户是否已注册 以及密码是否正确")
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name="loginName",value="用户名",dataType="String", paramType = "query",required = true),
            @ApiImplicitParam(name="password",value="密码",dataType="String", paramType = "query",required = true)})
    public Answer check(String loginName, String password){
        Answer<User> answer = userService.findUser(loginName);
        User user = answer.getData();
        if (null != user && !user.getPassword().equals(password)) {
            answer = AnswerGenerator.genFailAnswer("密码错误！");
        }
        return answer;
    }

    @ApiIgnore()
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/register";
    }

    @ApiOperation(value = "用户注册", notes = "新增用户 不可重复已存在的用户名")
    @RequestMapping(value = "/registerSave",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParam(name = "user",value = "用户实体类",dataType = "User",paramType = "body",required = true)
    public Answer newUser(@RequestBody User user){
        Answer answer = new Answer();
        try {
            answer = userService.saveUser(user);
        }catch (Exception e){
            answer = AnswerGenerator.genFailAnswer(e.getMessage());
            logger.error("注册 业务层错误",e);
        }
        return answer;
    }

    public String getWww() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
