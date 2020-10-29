package com.example.service;

import com.example.dao.OrderListDao;
import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderListDao orderListDao;

    public User findByName(String username) {

        return userDao.findByName(username);
    }

    public User findById(int id){

        return userDao.findByUserId(id);
    }

}
