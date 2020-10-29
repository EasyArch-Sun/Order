package com.example.dao;

import com.example.entity.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrderListDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderList findById(int id){

        final OrderList orderList=new OrderList();

        String sql="select userId, goodId from order_orderlist where userId=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                orderList.setGoodId(resultSet.getInt(1));
                orderList.setUserId(resultSet.getInt(2));
            }
        });



        return orderList;
    }

}
