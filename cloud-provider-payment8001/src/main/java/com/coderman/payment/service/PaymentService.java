package com.coderman.payment.service;

import com.coderman.common.vo.JsonData;
import com.coderman.payment.model.Payment;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:27
 * @Version 1.0
 **/
public interface PaymentService {

    /**
     * 查询支付信息
     * @param id
     * @return
     */
    Payment findById(Long id);

    /**
     * 支付接口
     * @param money
     * @param orderId
     */
    void create(String orderId,BigDecimal money);

    /**
     * 所有支付流水
     * @return
     */
    List<Payment> listAll();

}
