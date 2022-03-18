package com.hewen.utils.requestIntercept;

import org.slf4j.MDC;

/**
 * 2022/3/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class CommonResult<T> {
    private Integer code;
    private String message;
    private String traceId = MDC.get("traceId");
    private T data;
    private String path;

    public CommonResult() {
//        this.traceId = traceId;
    }

    public CommonResult(T data) {
        this(0,null,data);
    }

    public CommonResult(Integer code, String message) {
        this(code,message,null);
//        this.traceId = traceId;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
//        this.traceId = traceId;
    }

    public CommonResult(Integer code, String message, String traceId, T data, String path) {
        this.code = code;
        this.message = message;
//        this.traceId = traceId;
        this.data = data;
        this.path = path;
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

    public static CommonResult error(){
        return new CommonResult<>(999999,"未知异常，请联系管理员");
    }
}
