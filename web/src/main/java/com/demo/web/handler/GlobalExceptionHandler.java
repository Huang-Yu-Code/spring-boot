package com.demo.web.handler;

import com.demo.web.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 * 全局异常捕获处理器
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public Object serverError(Exception e) {
        log.error("异常信息", e);
        return ResponseUtils.failure();
    }

    @ExceptionHandler({IllegalArgumentException.class, MissingServletRequestParameterException.class})
    public Object clientError(Exception e) {
        log.error("异常信息", e);
        return ResponseUtils.failure(e.getMessage());
    }
}
