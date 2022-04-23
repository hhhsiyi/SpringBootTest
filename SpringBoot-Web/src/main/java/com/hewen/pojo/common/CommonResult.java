package com.hewen.pojo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName CommonResult
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/4/21 13:08
 */
public class CommonResult<T> implements Serializable {
    private String message;
    private Integer code = 0;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
