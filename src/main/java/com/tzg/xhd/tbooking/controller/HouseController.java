package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "住宿")
@Controller("houseController")
@RequestMapping(value = "/house")
public class HouseController {

    @RequestMapping(value = "/liveDetail",method = RequestMethod.GET)
    public String liveDetail(){
        return "house/roomerDetail";
    }

    @RequestMapping(value = "/firstRequest",method = RequestMethod.POST)
    @ResponseBody
    public Answer request1(String city, String roomTime, String roomDays, String roomAmount){
        Answer answer = new Answer();
        return answer;
    }
}
