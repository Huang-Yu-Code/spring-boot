package com.example.common.exception;

import com.example.common.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目: minio
 * 时间: 2021/11/9 15:08
 * 通用异常
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Getter
@Setter
public class CommonException extends RuntimeException {
    private StatusCode statusCode;

    public CommonException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.statusCode = statusCode;

    }
}
