package com.example.common.handler;

import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.system.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目: template
 * 时间: 2021/10/27 0:23
 * 全局异常捕获处理器
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Response> bindException(BindException e) {
        log.error(StatusCode.BIND_EXCEPTION.getMsg(), e);
        return ResponseEntity.badRequest().body(Response.failure(StatusCode.BIND_EXCEPTION));
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<Response> commonException(CommonException e) {
        log.error(e.getStatusCode().getMsg(), e);
        return ResponseEntity.badRequest().body(Response.failure(e.getStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exception(Exception e) {
        log.error("ERROR:", e);
        return ResponseEntity.internalServerError().body(Response.failure(StatusCode.SERVER_EXCEPTION));
    }

}
