package com.tzg.xhd.tbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexController")
public class IndexController {
    @RequestMapping(value = "/")
    public String main(){
        return "index";
    }

}
