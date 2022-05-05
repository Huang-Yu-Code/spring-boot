package com.example.minio.common.handler;

import com.example.minio.common.enums.ResponseCode;
import com.example.minio.common.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
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

    @ExceptionHandler({BindException.class})
    public ResponseEntity<Response> bindException(BindException e) {
        log.error("ERROR:", e);
        return ResponseEntity.badRequest().body(Response.failure(ResponseCode.BIND_EXCEPTION));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exception(Exception e) {
        log.error("ERROR:", e);
        return ResponseEntity.internalServerError().body(Response.failure(ResponseCode.SERVER_EXCEPTION));
    }

}
