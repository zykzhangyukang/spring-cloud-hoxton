package com.coderman.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhangyukang
 * @Date 2020/12/3 18:33
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.coderman.payment.mapper"})
public class Payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class,args);
    }
}
