package com.example.satoken.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.util.SaResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xsq
 * @version 1.0
 * @description: TODO
 * @date 2023/6/1 15:33
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常拦截
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        if (e instanceof NotLoginException) {
           NotLoginException ee = (NotLoginException) e;
            return SaResult.error(e.getMessage());
        }
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }
}

