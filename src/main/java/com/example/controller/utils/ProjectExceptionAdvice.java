package com.example.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为SpringMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        ex.printStackTrace();
        return new R("服务器故障, 请联系管理员");
    }
}
