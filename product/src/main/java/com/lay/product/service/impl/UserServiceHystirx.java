package com.lay.product.service.impl;

import com.lay.product.pojo.UserPo;
import com.lay.product.service.UserService;
import com.lay.util.wrapperUtil.WrapMapper;
import com.lay.util.wrapperUtil.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 15:54 2018/11/28
 * @Modified By:IntelliJ IDEA
 */
@Component
public class UserServiceHystirx implements UserService {
    @Override
    public UserPo getUser(@PathVariable("id") Long id) {
        UserPo userPo=new UserPo();
        userPo.setNote("获取用户ID="+id+"出错啦");
        return userPo;
    }

    @Override
    public Wrapper<String> testWrapper() {
        return WrapMapper.error("网络异常");
    }
}
