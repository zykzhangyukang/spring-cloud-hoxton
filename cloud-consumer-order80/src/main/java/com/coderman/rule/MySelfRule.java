package com.coderman.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangyukang
 * @Date 2020/12/8 17:00
 * @Version 1.0
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
