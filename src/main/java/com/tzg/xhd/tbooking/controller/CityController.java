package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.entity.Book;
import com.tzg.xhd.tbooking.entity.City;
import com.tzg.xhd.tbooking.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Api(description = "城市")
@Controller("cityContoller")
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * @Description 城市展示列表
     * @param model
     * @return list.html
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String index(Model model){
        PageHelper.startPage(1, 3);
        List<City> list = cityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("aaa","aaa");
        model.addAttribute("result", list);
        return "city/list";
    }

}
