package com.demo.sso.handler;

import com.demo.sso.util.ResponseUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        return ResponseUtils.serverError();
    }

    @ExceptionHandler({IllegalArgumentException.class, MissingServletRequestParameterException.class})
    public Object clientError(Exception e) {
        log.error("异常信息", e);
        return ResponseUtils.clientError(e.getMessage());
    }

    @ExceptionHandler({ExpiredJwtException.class, UnsupportedJwtException.class, MalformedJwtException.class, SignatureException.class})
    public Object unauthorizedException(Exception e) {
        log.error("异常信息", e);
        return ResponseUtils.failure(HttpStatus.UNAUTHORIZED, e.getMessage());
    }
}
