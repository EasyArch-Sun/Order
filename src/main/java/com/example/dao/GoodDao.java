package com.example.dao;

import com.example.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@CacheConfig(cacheNames = "good")
public class GoodDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Good findById(int id){

        final Good good=new Good();

        String sql="select id,name,price from order_good where id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                good.setId(resultSet.getInt(1));
                good.setName(resultSet.getString(2));
                good.setPrice(resultSet.getString(3));
            }
        });



        return good;
    }

}
