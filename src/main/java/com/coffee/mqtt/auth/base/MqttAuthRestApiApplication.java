package com.coffee.mqtt.auth.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"com.coffee"})
@ServletComponentScan
public class MqttAuthRestApiApplication {

    /**
     * 日志拦截器
     */
    @Autowired
    private LogInterceptor logInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(MqttAuthRestApiApplication.class, args);
    }

    /**
     * 实例化WebMvcConfigurer接口
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 添加拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(logInterceptor).addPathPatterns("/**");
            }

        };


    }

}
