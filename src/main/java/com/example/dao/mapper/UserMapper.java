package com.example.dao.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select(value = "SELECT id,name,password FROM order_user WHERE id=#{id}")
    User findById(@Param("id") int id);

    @Select(value = "SELECT id,name,age FROM t_user WHERE name=#{name}")
    User findByName(@Param("name") String name);

}
