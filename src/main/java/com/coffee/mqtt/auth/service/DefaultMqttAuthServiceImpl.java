package com.coffee.mqtt.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.coffee.mqtt.auth.exception.BaseResult;
import com.coffee.mqtt.auth.pojo.BrokerAuthInfo;
import com.coffee.mqtt.auth.pojo.BrokerType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @Name DefaultMqttAuthServiceImpl
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-10 11:13
 */
@Service
@Log4j2
@Configuration
@ConditionalOnProperty(prefix = "com.coffee.mqtt.auth.service",name = "impl",havingValue = "DEFAULT")
public class DefaultMqttAuthServiceImpl implements MqttAuthService {

    @Value("${com.coffee.mqtt.auth.method}")
    private String authMethod;

    @Override
    public BaseResult auth(String broker, String body) {

        log.info("[DefaultMqttAuthServiceImpl] authMethod="+authMethod);

        //TODO 添加客户端用户信息校验业务功能

        BrokerAuthInfo brokerAuthInfo = JSONObject.parseObject(body, BrokerAuthInfo.class);

        if (broker.equalsIgnoreCase(BrokerType.EMQX.name())) {
            if (!brokerAuthInfo.getClientid().equalsIgnoreCase("fourfaith001")) {
              return new BaseResult(false);
            }
        }

        if (broker.equalsIgnoreCase(BrokerType.ActiveMQ.name())) {

        }

        return new BaseResult(true);
    }

    @Override
    public BaseResult acl(String broker, String body) {
        //TODO 添加客户端用户信息鉴权业务功能
        if (broker.equalsIgnoreCase(BrokerType.EMQX.name())) {

        }

        if (broker.equalsIgnoreCase(BrokerType.ActiveMQ.name())) {

        }

        return new BaseResult(true);
    }
}
