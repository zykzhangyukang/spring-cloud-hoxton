package com.coderman.order.client;

import com.coderman.common.vo.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * @Author zhangyukang
 * @Date 2020/12/10 11:25
 * @Version 1.0
 **/

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/provider/payment/create/{orderId}/{money}")
    JsonData create(@PathVariable(value = "orderId") String orderId, @PathVariable(value = "money") BigDecimal money);
}
