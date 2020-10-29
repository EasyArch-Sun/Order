package com.example.controller;

import com.example.entity.Good;
import com.example.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "good_id",method = RequestMethod.GET)
    @ResponseBody
    public String findById(@RequestParam int id){
        Good goodById=goodService.findById(id);
        if(goodById!=null){
            return goodById.getName();
        }

        return "未找到该商品";
    }
}
