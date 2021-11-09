package com.demo.web.handler;

import com.demo.web.exception.ForbiddenException;
import com.demo.web.exception.UnauthorizedException;
import com.demo.web.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(Exception e) {
        e.printStackTrace();
        return ResponseUtils.failure(500, "服务器异常");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object illegalArgumentException(MissingServletRequestParameterException e) {
        e.printStackTrace();
        return ResponseUtils.failure("接口参数异常");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object illegalArgumentException(IllegalArgumentException e) {
        e.printStackTrace();
        return ResponseUtils.failure(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object runtimeException(RuntimeException e) {
        e.printStackTrace();
        return ResponseUtils.failure(e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object unauthorizedException(UnauthorizedException e) {
        return ResponseUtils.failure(401, e.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Object forbiddenException(ForbiddenException e) {
        e.printStackTrace();
        return ResponseUtils.failure(403, "未授权");
    }
}
