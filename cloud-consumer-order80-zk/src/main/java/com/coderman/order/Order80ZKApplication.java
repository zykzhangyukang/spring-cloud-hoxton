package com.coderman.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhangyukang
 * @Date 2020/12/3 18:26
 * @Version 1.0
 **/
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.coderman.order.mapper"})
public class Order80ZKApplication {

    public static void main(String[] args) {
        SpringApplication.run(Order80ZKApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
