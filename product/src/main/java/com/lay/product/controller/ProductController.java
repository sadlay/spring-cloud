package com.lay.product.controller;

import com.lay.product.pojo.UserPo;
import com.lay.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:50 2018/11/26
 * @Modified By:IntelliJ IDEA
 */
@RestController
@RequestMapping("product")
public class ProductController {

    // 注入RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/ribbon")
    public List<UserPo> testRibbon() {
        List<UserPo> list = new ArrayList<>();
        UserPo user = null;
        for (int i = 0; i < 10; i++) {
            //这里使用USER这个服务ID，代表用户维服务系统
            //该ID通过属性spring.application.name来指定
            //user = restTemplate.getForObject("http://USER/user/"+(i+1), UserPo.class);
            Long id= Long.valueOf((i+1));
            user=userService.getUser(id);
            list.add(user);
        }
        return list;
    }
}
