package com.example.Controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvicec {
//    拦截所有异常信息
    @ExceptionHandler(Exception.class)//具体拦截什么异常
    public Result doException(Exception e){
        e.printStackTrace();
        return new Result(false,"服务器故障，稍后再试");
    }
}
