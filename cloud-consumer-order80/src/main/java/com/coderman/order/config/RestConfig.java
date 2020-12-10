package com.coderman.order.config;

import com.coderman.rule.MySelfRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhangyukang
 * @Date 2020/12/8 16:51
 * @Version 1.0
 **/
@Configuration
//对于CLOUD-PAYMENT-SERVICE，使用复制均衡的规则为: MyRule
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = {MySelfRule.class})
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
