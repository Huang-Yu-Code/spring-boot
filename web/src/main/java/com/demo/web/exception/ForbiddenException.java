package com.demo.web.exception;

/**
 * 项目: spring-boot
 * 时间: 2021/10/22 0:54
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String message) {
        super(message);
    }
}
