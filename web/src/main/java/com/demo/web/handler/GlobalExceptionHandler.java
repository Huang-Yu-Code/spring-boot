package com.demo.web.handler;

import com.demo.web.exception.ForbiddenException;
import com.demo.web.exception.UnauthorizedException;
import com.demo.web.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(Exception e) {
        return ResponseUtils.failure(500, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object runtimeException(RuntimeException e) {
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
        return ResponseUtils.failure(403, e.getMessage());
    }
}
