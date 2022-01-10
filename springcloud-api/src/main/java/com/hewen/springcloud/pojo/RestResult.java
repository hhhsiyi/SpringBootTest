package com.hewen.springcloud.pojo;

import java.io.Serializable;

/**
 * 2022/1/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class RestResult<T> implements Serializable {
    public static final Integer SUCCESS_CODE = 0;
    private Integer code;//默认0最好啦
    private String message;
    private String traceId;
    private T data;
    private String path;

    public RestResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RestResult(Integer code) {
        this.code = code;
        this.message = "fail";
    }

    public RestResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", traceId='" + traceId + '\'' +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }

    public RestResult(Integer code, String message, String traceId, T data, String path) {
        this.code = code;
        this.message = message;
        this.traceId = traceId;
        this.data = data;
        this.path = path;
    }
}
