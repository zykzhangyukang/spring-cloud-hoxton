package com.coderman.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhangyukang
 * @Date 2020/12/3 18:33
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.coderman.payment.mapper"})
public class Payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class,args);
    }
}
