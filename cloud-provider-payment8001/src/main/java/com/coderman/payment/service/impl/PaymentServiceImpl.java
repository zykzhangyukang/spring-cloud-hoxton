package com.coderman.payment.service.impl;

import com.coderman.payment.mapper.PaymentMapper;
import com.coderman.payment.model.Payment;
import com.coderman.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:28
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment findById(Long id) {
        return paymentMapper.findById(id);
    }

    @Override
    public void create(BigDecimal money, String orderId) {
        System.out.println("支付服务-创建流水 订单号：" + orderId + ",金额：" + money);
        //支付流水号
        String serial = UUID.randomUUID().toString();
        paymentMapper.save(serial);
    }

    @Override
    public List<Payment> listAll() {
        return paymentMapper.listAll();
    }
}
