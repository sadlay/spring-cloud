package com.lay.cloud.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 14:43 2018/11/27
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class ConfigController {
    @Value("${user.key1}")
    private String key1;
    @Value("${user.key2}")
    private String key2;
    @Value("${user.key3}")
    private String key3;

    @GetMapping("/config")
    public String config(){
        return "key1="+key1+"  key2="+key2+"    key3="+key3;
    }
}
