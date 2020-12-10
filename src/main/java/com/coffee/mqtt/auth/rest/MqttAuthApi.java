package com.coffee.mqtt.auth.rest;

import com.coffee.mqtt.auth.exception.BaseResult;
import com.coffee.mqtt.auth.exception.MqttAuthException;
import com.coffee.mqtt.auth.pojo.BrokerAuthInfo;
import com.coffee.mqtt.auth.pojo.BrokerType;
import com.coffee.mqtt.auth.service.MqttAuthService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Name MqttAuthApi
 * @Description MQTT登录和鉴权接口
 * @Author huangyingfeng
 * @Create 2020-12-09 16:49
 */
@RestController
@RequestMapping("/mqtt")
@Log4j2
public class MqttAuthApi {

    @Autowired
    private MqttAuthService mqttAuthService;

    @RequestMapping(value = "/auth/{broker}")
    public String auth(@PathVariable final String broker, @RequestBody String body, HttpServletRequest request, HttpServletResponse response) {

        log.info("broker type is {} brokerAuthInfo is {}", broker, body);

        BaseResult baseResult = mqttAuthService.auth(broker, body);
        if (!baseResult.getIsSuccess()) {
            response.setStatus(403);
            throw new MqttAuthException("client " + body + " forbidden");
        }

        return broker;
    }


    @RequestMapping(value = "/acl/{broker}")
    public String acl(@PathVariable final String broker, @RequestBody String body, HttpServletRequest request, HttpServletResponse response) {

        log.info("broker type is {} body is {}", broker, body);

        BaseResult baseResult = mqttAuthService.acl(broker, body);
        if (!baseResult.getIsSuccess()) {
            response.setStatus(403);
            throw new MqttAuthException("client " + body + " forbidden");
        }

        return broker;
    }

}
