package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.VO.TripPlanVO;
import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.AnswerGenerator;
import com.tzg.xhd.tbooking.emuns.ProvinceEmuns;
import com.tzg.xhd.tbooking.entity.City;
import com.tzg.xhd.tbooking.entity.TripPlan;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.service.CityService;
import com.tzg.xhd.tbooking.service.TripPlanService;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import com.tzg.xhd.tbooking.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Api(description = "城市")
@Slf4j
@Controller("cityContoller")
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private TripPlanService tripPlanService;


    @ApiOperation(value = "目的地页面", notes = "目的地展示国内各省份")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String index(Model model){
        User user = HttpSessionUtil.getLoginUserSession();
        model.addAttribute("user", user);
        return "city/province";
    }

    @ApiOperation(value = "城市列表页面", notes = "点击省份之后跳出来的该省城市列表页面")
    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public String province(Model model,String provinceId){
        List<City> citys = cityService.getCityByProvince(provinceId);
        model.addAttribute("citys",citys);
        return "city/citys";
    }

    @ApiOperation(value = "城市详情页面", notes = "点击城市之后跳出来的城市详情页面")
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public String city(Model model, String cityId){
        City city = cityService.findById(Integer.parseInt(cityId));
        TripPlan tripPlan = new TripPlan();
        tripPlan.setCityId(Integer.parseInt(cityId));
        List<TripPlanVO> tripPlans = tripPlanService.getTripPlanVOList(tripPlan);
        model.addAttribute("user",HttpSessionUtil.getLoginUserSession());
        model.addAttribute("city",city);
        model.addAttribute("tripPlans",tripPlans);
        model.addAttribute("province",ProvinceEmuns.getNameById(city.getProvince()));
        return "city/cityDetail";
    }

}
