package com.coderman.order.model;

import java.math.BigDecimal;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:54
 * @Version 1.0
 **/
public class Order {
    private Long id;
    private String orderId;
    private BigDecimal money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", money=" + money +
                '}';
    }
}
