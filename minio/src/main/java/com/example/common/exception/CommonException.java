package com.example.common.exception;

/**
 * 项目: minio
 * 时间: 2021/11/9 15:08
 * 通用异常
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */

public class CommonException extends RuntimeException {
    public CommonException(String message) {
        super(message);
    }
}
