package com.coffee.mqtt.auth.service;

import com.coffee.mqtt.auth.exception.BaseResult;
import com.coffee.mqtt.auth.pojo.BrokerAuthInfo;

/**
 * @Name MqttAuthService
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-10 11:07
 */
public interface MqttAuthService {
    /**
     * 登录验证
     * @param broker
     * @param body
     * @return
     */
    BaseResult auth(String broker,String body);

    /**
     * 鉴权验证
     * @param broker
     * @param body
     * @return
     */
    BaseResult acl(String broker,String body);
}
