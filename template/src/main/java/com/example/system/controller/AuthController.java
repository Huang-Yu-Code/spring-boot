package com.example.system.controller;

import com.example.system.entity.Response;
import com.example.system.entity.User;
import com.example.system.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: template
 * 时间: 2022/4/1 16:37
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public Response login(@Validated @RequestBody User user) {
        String token = authService.login(user);
        return Response.success(token);
    }

    @PostMapping("/logout")
    public Response logout() {
        authService.logout();
        return Response.success();
    }
}
