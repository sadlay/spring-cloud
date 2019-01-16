package com.lay.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//启用发现服务注解，新版本已经不需要再使用了
//@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lay.product")
@EnableHystrix
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    //初始化RestTemplate
    @LoadBalanced //多节点负载均衡
    @Bean(name="restTemplate")
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
}
