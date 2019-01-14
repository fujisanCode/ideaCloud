package com.rai.zuulservice.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 * 设置权限校验的过滤器，请求时必须带有token，否则不进行路由
 */
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 定义过滤器中需要完成业务
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //zuul的context
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);
            return null;
        }else{
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.setResponseBody("token is empty.");
            context.set("isSuccess", false);
            return null;
        }
    }
}
