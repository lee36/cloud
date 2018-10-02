package com.lee.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.ZuulProxyAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ZuulConstants.ZUUL_FILTER_PRE_PATH;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //获取request
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //拦截与否
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //拦截后逻辑
        return null;
    }
}
