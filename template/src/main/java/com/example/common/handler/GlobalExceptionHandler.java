package com.example.common.handler;

import com.example.common.entity.R;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
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
    public R<Void> bindException(BindException e) {
        log.error(StatusCode.BIND_EXCEPTION.getMessage(), e);
        return R.failure(StatusCode.BIND_EXCEPTION);
    }

    @ExceptionHandler(CommonException.class)
    public R<Void> commonException(CommonException e) {
        log.error(e.getStatusCode().getMessage(), e);
        return R.failure(e.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public R<Void> exception(Exception e) {
        log.error("ERROR:", e);
        return R.failure(StatusCode.SERVER_EXCEPTION);
    }

}
