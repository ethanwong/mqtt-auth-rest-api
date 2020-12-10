package com.coffee.mqtt.auth.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * @Name MqttClientApi
 * @Description 客户端用户信息管理接口
 * @Author huangyingfeng
 * @Create 2020-12-10 10:59
 */
@RestController
@RequestMapping("/mqtt/client")
@Log4j2
public class MqttClientApi {

    @PostMapping("")
    public void add(){
        log.info("MqttClientApi add");
    }

    @DeleteMapping("")
    public void remove(){
        log.info("MqttClientApi remove");
    }

    @PutMapping("")
    public void update(){
        log.info("MqttClientApi update");
    }

    @GetMapping("")
    public void list(){
        log.info("MqttClientApi update");
    }

}
