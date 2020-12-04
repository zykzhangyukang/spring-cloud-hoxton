package com.coderman.payment.controller;

import com.coderman.common.vo.JsonData;
import com.coderman.payment.model.Payment;
import com.coderman.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:28
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/provider/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 查询所有支付流水
     *
     * @return
     */
    @GetMapping(value = "/listAll")
    public JsonData listAll() {
        return JsonData.success(paymentService.listAll());
    }


    /**
     * 根据id查询流水
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/get/{id}")
    public JsonData findById(@PathVariable(value = "id") Long id) {
        return JsonData.success(paymentService.findById(id));
    }


    /**
     * 支付订单
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/create/{orderId}/{money}")
    public JsonData create(@PathVariable(value = "orderId") String orderId,
                      @PathVariable(value = "money") BigDecimal money) {
        paymentService.create(money, orderId);
        return JsonData.success("支付订单成功");
    }

}
