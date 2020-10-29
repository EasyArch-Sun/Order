package com.example.controller;

import com.example.entity.OrderList;
import com.example.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    @RequestMapping(value = "find_goodId by userId",method = RequestMethod.GET)
    @ResponseBody
    public OrderList findById(@RequestParam int userId){
        OrderList orderListById=orderListService.findGoodIdByUserId(userId);

        return orderListById;

    }
}
