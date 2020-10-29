package com.example.service;

import com.example.dao.OrderListDao;
import com.example.entity.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderListService {

    @Autowired
    private OrderListDao orderListDao;


    public OrderList findGoodIdByUserId(int id){

        return orderListDao.findById(id);
    }
}
