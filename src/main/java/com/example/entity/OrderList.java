package com.example.entity;

import java.io.Serializable;

public class OrderList implements Serializable {

    private int userId;
    private int goodId;

    public OrderList(){
    }

    public OrderList(int userId, int goodId) {
        this.userId = userId;
        this.goodId = goodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }
}
