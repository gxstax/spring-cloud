package com.ant.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter{

    /**
     * 过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器级别，默认值+1在默认过滤器后面执行，-1则在默认过滤器之前执行
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
    }

    /**
     * 过滤器启不启用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("request:" + ctx.getRequest());
        System.out.println("response:" + ctx.getResponse());
        Object requestUrl = ctx.get(FilterConstants.REQUEST_URI_KEY);
        System.out.println(request.getRemoteAddr() + "访问了" + request.getRequestURI()+
                "路由后的地址" + requestUrl.toString());
        return null;
    }
}
