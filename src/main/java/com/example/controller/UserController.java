package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user_id",method = RequestMethod.GET)
    @ResponseBody
    public String findById(@RequestParam int id){
        User userById=userService.findById(id);
        if(userById!=null){
            return userById.getName();
        }
        return "未找到该用户";
    }
}
