package com.coderman.order.mapper;

import com.coderman.order.model.Order;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 13:00
 * @Version 1.0
 **/
public interface OrderMapper {
    public Order findByOrderId(String orderId);
}
