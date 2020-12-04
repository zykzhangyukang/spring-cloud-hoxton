package com.coderman.order.service;

import com.coderman.order.model.Order;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:59
 * @Version 1.0
 **/
public interface OrderService {
    Order pay(String orderId);
}
