package com.coderman.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhangyukang
 * @Date 2020/12/3 18:33
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.coderman.payment.mapper"})
public class Payment8004ConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004ConsulApplication.class,args);
    }
}
