package com.demo.web.exception;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
