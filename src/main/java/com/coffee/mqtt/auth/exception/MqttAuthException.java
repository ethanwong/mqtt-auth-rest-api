package com.coffee.mqtt.auth.exception;

/**
 * @Name MqttAuthException
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-10 10:39
 */
public class MqttAuthException extends RuntimeException {

    public Integer statusCode;

    public MqttAuthException() {
        super();
    }

    public MqttAuthException(String s) {
        super(s);
    }

    public MqttAuthException(Integer statusCode,String s) {
        super(s);
        this.statusCode = statusCode;
    }
}
