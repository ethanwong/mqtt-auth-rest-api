# MQTT-AUTH-REST-APi
为MQTT Broker服务提供登录和鉴权验证,兼容以下MQTT Broker<br>
1、EMQ X Broker v4.2.3<br>
2、apache-artemis-2.16.0<br>

该API提供两种可配置的验证模式（clientId-password、username-password）<br>
在配置文件“application.yml”进行指定<br>
com:coffee:mqtt:auth:method:clientId-password #username-password<br>

## 鉴权校验REST API
### 1、连接校验
uri:/mqtt/auth/{broker}<br>
uri参数:broker取值为EMQX或者ActiveMQ<br>
method:post<br>
content-type:application/json<br>

#### broker值为EMQX时
请求参数:<br>
clientid=%c,username=%u,password=%P<br>

%c：Client ID<br>
%u：用户名<br>
%P：明文密码<br>

请求响应<br>
认证失败：API 返回 4xx 状态码<br>
认证成功：API 返回 200 状态码<br>
忽略认证：API 返回 200 状态码且消息体 ignore<br>

#### broker值为ActiveMQ时
ActiveMQ:<br>

### 2、鉴权校验
uri:/mqtt/acl/{broker}<br>
uri参数:broker取值为EMQX或者ActiveMQ<br>
method:get<br>
content-type:application/json<br>

#### broker值为EMQX时
请求参数:<br>
access=%A,username=%u,clientid=%c,ipaddr=%a,topic=%t,mountpoint=%m

%A: 1 | 2, 1 = sub, 2 = pub<br>
%u：用户名<br>
%c：Client ID<br>
%a: ipaddress<br>
%t: topic<br>
%m: mountpoint<br>

请求响应<br>
认证失败：API 返回 4xx 状态码<br>
认证成功：API 返回 200 状态码<br>
忽略认证：API 返回 200 状态码且消息体 ignore<br>

#### broker值为ActiveMQ时
请求参数:<br>

请求响应<br>

## 辅助管理REST API
### 1、查询客户端用户信息列表
uri:/mqtt/client<br>
method:get<br>
content-type:application/json<br>

### 2、添加客户端和用户信息
uri:/mqtt/client<br>
method:post<br>
content-type:application/json<br>

###3、修改客户端和用户信息
uri:/mqtt/client<br>
method:put<br>
content-type:application/json<br>

### 4、删除客户端和用户信息
uri:/mqtt/client<br>
method:delete<br>
content-type:application/json<br>

## TODO
1、客户端用户信息管理；

2、登录验证业务逻辑添加，也可自定义接口进行实现；

3、鉴权验证业务逻辑添加，也可自定义接口进行实现；

## 代码简单介绍
1、解决不能多次读取request里面的body内容；

2、通过yml配置实现接口适配不同的实现类；

3、通过全局拦截异常实现异常业务的封装；

4、拦截请求信息，通过日志进行打印和记录；

5、通过log4j2实现日志的打印和记录；




