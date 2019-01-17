package com.lay.cloud;

import com.lay.cloud.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//启动zuul代理功能
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);

    }
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
