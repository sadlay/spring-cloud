package com.lay.cloud.user.controller;

import com.lay.cloud.pojo.UserPo;
import com.lay.cloud.util.wrapperUtil.WrapMapper;
import com.lay.cloud.util.wrapperUtil.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:34 2018/11/26
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class UserController {
    @Autowired
    RedisTemplate redisTemplate;

    //日志
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    //服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    //获取用户信息
    @GetMapping("/user/{id}")
    public UserPo getUserPo(@PathVariable("id") Long id, HttpSession session) {
        log.warn("=============User sessionId=================:{}",session.getId());
        log.warn("lay :{}",session.getAttribute("lay"));
        ServiceInstance service = discoveryClient.getInstances("USER").get(0);
        log.info("【" + service.getServiceId() + "】" + service.getHost() + ": " + service.getPort());
        UserPo userPo = new UserPo();
        userPo.setId(id);
        userPo.setLevel((int) (id & 3 + 1));
        userPo.setUserName("user_name_" + id);
        userPo.setNote("note_" + id);
        return userPo;
    }

    @GetMapping("/wrapper")
    public Wrapper<String> testWrapper() {
        return WrapMapper.ok("测试包装类wrapper");
    }
}
