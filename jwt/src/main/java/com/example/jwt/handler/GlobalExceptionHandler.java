package com.example.jwt.handler;

import com.example.jwt.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public Object exception(Exception e) {
        log.error("异常信息:", e);
        return ResponseUtils.failure();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Object illegalArgumentException(Exception e) {
        log.error("异常信息:", e);
        return ResponseUtils.failure(e.getMessage());
    }
}
