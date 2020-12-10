package com.coffee.mqtt.auth.base;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Name ChannelFilter
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-09 18:33
 */
@WebFilter(urlPatterns = "/*", filterName = "channelFilter")
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (servletRequest instanceof HttpServletRequest) {
            requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        }
        if (requestWrapper == null) {
            System.out.println("servletRequest");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("requestWrapper");
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
