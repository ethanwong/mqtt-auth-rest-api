package com.coffee.mqtt.auth.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Name GlobalExceptionHandler
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-10 10:29
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MqttAuthException.class)
    public BaseResult globalException(HttpServletResponse response, MqttAuthException ex) {
        log.info("[GlobalExceptionHandler] Response status:" + response.getStatus());
        return new BaseResult(false, "request error:" + response.getStatus(), "GlobalExceptionHandler:" + ex.getMessage());
    }
}
