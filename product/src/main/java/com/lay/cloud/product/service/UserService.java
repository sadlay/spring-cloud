package com.lay.cloud.product.service;

import com.lay.cloud.pojo.UserPo;
import com.lay.cloud.product.service.impl.UserServiceHystirx;
import com.lay.cloud.util.wrapperUtil.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:35 2018/11/26
 * @Modified By:IntelliJ IDEA
 */
@FeignClient(value = "user",fallback = UserServiceHystirx.class )
public interface UserService {

    @GetMapping("/user/{id}")
    public UserPo getUser(@PathVariable("id") Long id);

    @GetMapping("/wrapper")
    Wrapper<String> testWrapper();
}
