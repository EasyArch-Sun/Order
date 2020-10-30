package com.example.service;

import com.example.dao.GoodDao;
import com.example.dao.OrderListDao;
import com.example.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GoodService {

    @Autowired
    private GoodDao goodDao;

    @Autowired
    private OrderListDao orderListDao;


    @Cacheable(cacheNames = "good",key = "#id")
    public Good findById(int id){

        return goodDao.findById(id);
    }
}
