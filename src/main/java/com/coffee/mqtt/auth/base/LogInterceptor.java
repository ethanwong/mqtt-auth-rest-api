package com.coffee.mqtt.auth.base;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Log4j2
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("Request Method:{},URI:{},QueryString:{}", request.getMethod(), request.getRequestURI(), request.getQueryString());
        try {
            RequestWrapper requestWrapper = new RequestWrapper(request);
            String body = requestWrapper.getBody();
            log.info("Request Content-Type:{},Request Body:{}", request.getContentType(), body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
