package com.coderman.payment.mapper;

import com.coderman.payment.model.Payment;

import java.util.List;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:22
 * @Version 1.0
 **/
public interface PaymentMapper {
    Payment findById(Long id);
    void save(String serial);
    List<Payment> listAll();

}
