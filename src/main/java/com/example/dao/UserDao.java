package com.example.dao;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@CacheConfig(cacheNames = "user")
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUserId(int id){
        final User user=new User();
        String sql="SELECT id,name,password FROM order_user WHERE id=?";

        jdbcTemplate.query(sql, new Object[id], new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
            }
        });

        return user;
    }

    public User findByName(String name){

        final User user=new User();
        String sql = "SELECT id,name FROM order_user WHERE name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
            }
        });

        return user;
    }



}
