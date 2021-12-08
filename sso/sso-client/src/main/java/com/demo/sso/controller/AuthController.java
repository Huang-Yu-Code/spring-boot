package com.demo.sso.controller;

import com.demo.sso.dto.Login;
import com.demo.sso.dto.Logon;
import com.demo.sso.service.AuthService;
import com.demo.sso.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: spring-boot
 * 时间: 2021/11/24 0:58
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/logon")
    public Object logon(Logon logon) {
        Object data = authService.logon(logon);
        return ResponseUtils.success(HttpStatus.CREATED, data);
    }

    @PostMapping("/login")
    public Object login(@RequestBody Login login) {
        Object data = authService.login(login);
        return ResponseUtils.success(HttpStatus.OK, data);
    }

    @PostMapping("/logout")
    public Object logout() {
        authService.logout();
        return ResponseUtils.success(HttpStatus.OK, null);
    }
}
