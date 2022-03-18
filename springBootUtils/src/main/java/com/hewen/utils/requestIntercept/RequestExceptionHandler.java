package com.hewen.utils.requestIntercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 2022/3/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RestControllerAdvice
public class RequestExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(RequestExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult vaildError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String field = fieldError.getField();
        String defaultMessage = fieldError.getDefaultMessage();
        logger.error("字段名："+field+"  错误信息为："+defaultMessage);
        return new CommonResult(999999,"字段名："+field+"  错误信息为："+defaultMessage);
    }

//    /**
//     * 处理自定义异常
//     */
//    @ExceptionHandler(RRException.class)
//    public CommonResult handleRRException(RRException e){
//        CommonResult r = new CommonResult();
//
//
//        return r;
//    }
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    public R handleDuplicateKeyException(DuplicateKeyException e){
//        logger.error(e.getMessage(), e);
//        return R.error("数据库中已存在该记录");
//    }
//
//    @ExceptionHandler(AuthorizationException.class)
//    public R handleAuthorizationException(AuthorizationException e){
//        logger.error(e.getMessage(), e);
//        return R.error("没有权限，请联系管理员授权");
//    }

    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e){
        logger.error(e.getMessage(), e);
        return CommonResult.error();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult validationError(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        logger.error(fieldError.getField()+fieldError.getDefaultMessage());
//        return CommonResult.error(9999, fieldError.getField()+fieldError.getDefaultMessage());
        return CommonResult.error();
    }
}
