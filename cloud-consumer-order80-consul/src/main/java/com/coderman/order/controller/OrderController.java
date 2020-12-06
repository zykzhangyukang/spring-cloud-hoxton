package com.coderman.order.controller;

import com.coderman.common.vo.JsonData;
import com.coderman.order.model.Order;
import com.coderman.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:55
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/consumer/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String REST_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 订单支付
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/pay/{orderId}")
    public JsonData pay(@PathVariable(value = "orderId") String orderId) {
        Order order = orderService.pay(orderId);
        if (order == null) {
            logger.info("订单服务-没有查询到订单,orderId:{}", orderId);
            return JsonData.fail("order not found");
        } else {
            logger.info("订单服务-查询到订单:{}", order);
            JsonData result = restTemplate.getForObject(REST_URL + "/provider/payment/create/" + order.getOrderId() + "/" + order.getMoney(), JsonData.class);
            logger.info("订单服务-调用支付服务,result:{}", result);
            return JsonData.success("pay order success!,result="+result);
        }
    }
}
