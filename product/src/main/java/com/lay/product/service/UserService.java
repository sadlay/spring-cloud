package com.lay.product.service;

import com.lay.product.pojo.UserPo;
import com.lay.product.service.impl.UserServiceHystirx;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:35 2018/11/26
 * @Modified By:IntelliJ IDEA
 */
@FeignClient(value = "user",fallback = UserServiceHystirx.class)
public interface UserService {

    @GetMapping("/user/{id}")
    public UserPo getUser(@PathVariable("id") Long id);

}
