package com.tzg.xhd.tbooking.controller;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.entity.Book;
import com.tzg.xhd.tbooking.entity.Province;
import com.tzg.xhd.tbooking.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("provinceContoller")
@RequestMapping(value = "province")
public class ProvinceController {
    @Autowired
    private ProvinceService ProvinceService;

    /**
     * @Description 省份展示列表
     * @param model
     * @return list.html
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("aaa","aaa");
        model.addAttribute("result", ProvinceService.getAllProvince());
        return "province/list";
    }

    /**
     * @Description 新增省份信息
     * @param province
     * @return Answer<String>
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public Answer<String> addProvince(@RequestBody Province province){
        Answer<String> answer = new Answer<String>();
        try{
            ProvinceService.save(province);
            answer.setSuccess(true);
            answer.setMessage("新增省份信息成功！");
        }catch (Exception e){
            answer.setSuccess(false);
            answer.setMessage("新增省份信息失败！");
        }
        return answer;
    }

    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    @ResponseBody
    public Book bookindex(@PathVariable("bookId")Integer bookId){
        return new Book(bookId,"book"+bookId);
    }
}
