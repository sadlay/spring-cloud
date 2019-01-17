package com.lay.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:58 2019/1/16
 * @Modified By:IntelliJ IDEA
 */
public class AccessFilter extends ZuulFilter {
    private static final Logger log= LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;


    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpSession session=request.getSession();
        session.setAttribute("lay","never give up!");
        String sessionId = session.getId();
        //ctx.addZuulRequestHeader("Cookie", "SESSION=" + sessionId);
        if(!request.isRequestedSessionIdValid()){
            String sessionBase64 =  Base64.getEncoder().encodeToString(session.getId().getBytes());
            ctx.addZuulRequestHeader("Cookie", "SESSION=" + sessionBase64);
            log.info("Session Base64:{}",sessionBase64);
        }
        ctx.setSendZuulResponse(true);// 对该请求进行路由
        ctx.setResponseStatusCode(200); // 返回200正确响应
        log.info("====================Zuul seesion===========================:{}",sessionId);
        return ctx;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
