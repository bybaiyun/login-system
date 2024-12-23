package com.example.handler;

import com.example.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类
 * @Author: suragi
 * @Date: 2024/12/23 20:36
 * @Description:
 */
@ControllerAdvice
public class BizExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleBizException(Exception e){
        return Result.error(500, e.getMessage());
    }
}

