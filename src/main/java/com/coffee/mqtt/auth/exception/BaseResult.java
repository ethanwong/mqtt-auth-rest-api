package com.coffee.mqtt.auth.exception;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Name BaseResult
 * @Description
 * @Author huangyingfeng
 * @Create 2020-12-10 10:30
 */
@Data
public class BaseResult implements Serializable {

    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;

    private String uuid = UUID.randomUUID().toString().replace("-", "");
    /**
     * 返回代码 true-成功，false-失败
     */
    private Boolean isSuccess;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回对象
     */
    private Object data;

    public BaseResult() {
    }

    public BaseResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public BaseResult(Boolean isSuccess, String message, Object data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

}
