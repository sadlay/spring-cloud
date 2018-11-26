package com.lay.user.controller;

import com.lay.user.pojo.UserPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:34 2018/11/26
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class UserController {
    //日志
    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    //服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    //获取用户信息
    @GetMapping("/user/{id}")
    public UserPo getUserPo(@PathVariable("id") Long id){
        ServiceInstance service = discoveryClient.getInstances("USER").get(0);
        log.info("【"+service.getServiceId()+"】"+service.getHost()+": "+service.getPort());
        UserPo userPo=new UserPo();
        userPo.setId(id);
        userPo.setLevel((int) (id&3+1));
        userPo.setUserName("user_name_"+id);
        userPo.setNote("note_"+id);
        return userPo;
    }
}
