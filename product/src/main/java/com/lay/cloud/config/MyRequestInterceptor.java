package com.lay.cloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:56 2019/1/17
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class MyRequestInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(MyRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        log.info("MyRequestInterceptor apply begin");
        try {
            String sessionId1=RequestContextHolder.currentRequestAttributes().getSessionId();
            log.info("RequestContextHolder sessionId1 :{}",sessionId1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
