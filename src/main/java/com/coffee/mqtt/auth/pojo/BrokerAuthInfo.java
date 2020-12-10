package com.coffee.mqtt.auth.pojo;

import lombok.Data;

/**
 * @Name BrokerAuthInfo
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-09 18:24
 */
@Data
public class BrokerAuthInfo {
    private String clientid;
    private String username;
    private String password;
}
