package com.demo.web.controller;

import com.demo.web.exception.ForbiddenException;
import com.demo.web.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: spring-boot
 * 时间: 2021/10/22 0:47
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
public class ExceptionController {
    @GetMapping("/exception")
    public Object exception() throws Exception {
        throw new Exception("服务器异常");
    }

    @GetMapping("/runtimeException")
    public Object runtimeException() {
        throw new RuntimeException("运行时异常");
    }

    @GetMapping("/unauthorizedException")
    public Object unauthorizedException() {
        throw new UnauthorizedException("认证异常");
    }

    @GetMapping("/forbiddenException")
    public Object forbiddenException() {
        throw new ForbiddenException("授权异常");
    }
}
