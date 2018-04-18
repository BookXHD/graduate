package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.AnswerGenerator;
import com.tzg.xhd.tbooking.emuns.ProvinceEmuns;
import com.tzg.xhd.tbooking.entity.City;
import com.tzg.xhd.tbooking.entity.TripPlan;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.service.CityService;
import com.tzg.xhd.tbooking.service.TripPlanService;
import com.tzg.xhd.tbooking.util.HttpSessionUtil;
import io.swagger.annotations.Api;
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


    /**
     * @Description 城市展示列表
     * @param model
     * @return province.html
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String index(Model model){
//        PageHelper.startPage(1, 3);
//        List<City> list = cityService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
        User user = HttpSessionUtil.getLoginUserSession();
        model.addAttribute("user", user);
//        model.addAttribute("result", list);
        return "city/province";
    }

    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public String province(Model model,String provinceId){
        List<City> citys = cityService.getCityByProvince(provinceId);
        model.addAttribute("citys",citys);
        return "city/citys";
    }

    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public String city(Model model, String cityId){
        City city = cityService.findById(Integer.parseInt(cityId));
        TripPlan tripPlan = new TripPlan();
        tripPlan.setCityId(Integer.parseInt(cityId));
        List<TripPlan> tripPlans = tripPlanService.findByModel(tripPlan);
        model.addAttribute("user",HttpSessionUtil.getLoginUserSession());
        model.addAttribute("city",city);
        model.addAttribute("tripPlans",tripPlans);
        model.addAttribute("province",ProvinceEmuns.getNameById(city.getProvince()));
        return "city/cityDetail";
    }

}
