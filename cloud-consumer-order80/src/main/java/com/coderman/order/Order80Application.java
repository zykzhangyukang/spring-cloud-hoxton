package com.coderman.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhangyukang
 * @Date 2020/12/3 18:26
 * @Version 1.0
 **/
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.coderman.order.mapper"})
public class Order80Application {

    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class,args);
    }
}
