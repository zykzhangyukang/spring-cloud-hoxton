package com.coderman.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 14:15
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka7003Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7003Application.class,args);
    }
}
