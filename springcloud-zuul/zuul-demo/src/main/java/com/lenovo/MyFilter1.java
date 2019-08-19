package com.lenovo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter1 extends ZuulFilter {
    /**
     * 类型包含 pre post route error
     * pre 代表在路由代理之前执行
     * route 代表代理的时候执行
     * error 代表出现错的时候执行
     * post 代表在route 或者是 error 执行完成后执行
     */
    @Override
    public String filterType() {
// 路由之前(前置过滤器)
        return FilterConstants.PRE_TYPE;
    }
    @Override
    public int filterOrder() {
// 优先级，数字越大，优先级越低
        return 1;
    }
    @Override
    public boolean shouldFilter() {
// 是否执行该过滤器，true代表需要过滤
        return true;
    }
    @Override
    public Object run() {
        System.out.println("11111111111111111111111111");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Object token = request.getAttribute("token");
        if(StringUtils.isEmpty(token)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().print("token error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //业务逻辑
        return null;
    }
}