package com.lay.cloud.config;

import com.lay.cloud.constant.GlobalConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:00 2019/1/16
 * @Modified By:IntelliJ IDEA
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= GlobalConstant.SESSION_TIMOUT,redisFlushMode= RedisFlushMode.IMMEDIATE)
public class SessionConfig {

    @PostConstruct
    public void test(){
        System.out.println("init sessionConfig");
    }

}
