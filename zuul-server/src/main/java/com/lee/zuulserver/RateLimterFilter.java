package com.lee.zuulserver;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class RateLimterFilter extends ZuulFilter {

    private static final RateLimiter LIMITER=RateLimiter.create(1000);

    @Override
    public String filterType() {
        return ZuulConstants.ZUUL_FILTER_PRE_PATH;
    }

    @Override
    public int filterOrder() {
        return -3;
    }

    @Override
    public boolean shouldFilter() {
        //判断url是否是要限流的url
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //没获取到
        if(!LIMITER.tryAcquire()){
            RequestContext.getCurrentContext().setSendZuulResponse(false);
            RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.MULTI_STATUS.value());
        }
        //获取到后
        return null;
    }
}
