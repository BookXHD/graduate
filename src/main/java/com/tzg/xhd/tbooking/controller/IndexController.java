package com.tzg.xhd.tbooking.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(description = "首页")
@Controller("indexController")
public class IndexController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(){
        return "index";
    }

}
