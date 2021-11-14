package com.demo.jwt.handler;

import com.demo.jwt.util.ResponseUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目: spring-boot
 * 时间: 2021/11/14 23:18
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object exception(Exception e) {
        e.printStackTrace();
        return ResponseUtils.failure();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Object illegalArgumentException(Exception e) {
        e.printStackTrace();
        return ResponseUtils.failure(e.getMessage());
    }
}
