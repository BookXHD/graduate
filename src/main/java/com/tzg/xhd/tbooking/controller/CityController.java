package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.eastnan.entity.Hotel;
import com.tzg.xhd.eastnan.service.HotelService;
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
import com.tzg.xhd.tbooking.util.IPAdressUtil;
import com.tzg.xhd.tbooking.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "城市")
@Slf4j
@Controller("cityContoller")
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private TripPlanService tripPlanService;

    @Autowired
    private HotelService hotelService;


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

    @ApiIgnore()
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

    @ApiOperation(value = "城市详情页面", notes = "点击城市之后跳出来的城市详情页面 返回map,放了城市数据和对应城市的旅游路线数据")
    @RequestMapping(value = "/cityDetail",method = RequestMethod.GET)
    @ResponseBody
    public Answer cityDetail(String id){
        Answer answer = new Answer();
        try {
        City city = cityService.findById(Integer.parseInt(id));
        TripPlan tripPlan = new TripPlan();
        tripPlan.setCityId(Integer.parseInt(id));
        List<TripPlanVO> tripPlans = tripPlanService.getTripPlanVOList(tripPlan);
        List<Hotel> hotels = hotelService.selectHotel(null,id,null,null,null);
        Map<String,Object> map = new HashMap<>();
        map.put("city",city);
        map.put("tripPlans",tripPlans);
        map.put("hotels",hotels);
        answer = AnswerGenerator.genSuccessAnswer(map);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("城市详情页面后台请求出错！");
        }
        return answer;
    }

    @ApiOperation(value = "当前城市", notes = "返回登录用户当前的城市定位")
    @RequestMapping(value = "/currentCity",method = RequestMethod.GET)
    @ResponseBody
    public Answer currentCity(){
        Answer answer = new Answer();
        try {
            User user = HttpSessionUtil.getLoginUserSession();
            if(null == user){
                return AnswerGenerator.genFailAnswer("用户未登录或登录已过时,请先登录！");
            }
            String currentCity = IPAdressUtil.getCurrentCtiy();
            answer = AnswerGenerator.genSuccessAnswer("用户当前所在的省市为:"+currentCity);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("当前城市 后台请求出错！");
        }
        return answer;
    }

    @ApiOperation(value = "城市查询", notes = "返回城市的右模糊查询结果")
    @RequestMapping(value = "/queryCity",method = RequestMethod.GET)
    @ResponseBody
    public Answer queryCity(String cityName){
        Answer answer = new Answer();
        try {
            List<City> cities = cityService.getCityByName(cityName);
            answer = AnswerGenerator.genSuccessAnswer(cities);
        } catch (Exception e) {
            log.error(e.getMessage());
            answer = AnswerGenerator.genFailAnswer("城市查询 后台请求出错！");
        }
        return answer;
    }
}
