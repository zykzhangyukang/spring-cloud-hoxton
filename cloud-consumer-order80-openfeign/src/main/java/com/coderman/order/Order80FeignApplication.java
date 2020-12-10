package com.coderman.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhangyukang
 * @Date 2020/12/3 18:26
 * @Version 1.0
 **/
@EnableEurekaClient
@EnableFeignClients //开启Feign
@SpringBootApplication
@MapperScan(basePackages = {"com.coderman.order.mapper"})
public class Order80FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Order80FeignApplication.class,args);
    }
}
