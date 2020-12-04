package com.coderman.order.service.impl;

import com.coderman.order.mapper.OrderMapper;
import com.coderman.order.model.Order;
import com.coderman.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 13:00
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order pay(String orderId) {
        return orderMapper.findByOrderId(orderId);
    }
}
