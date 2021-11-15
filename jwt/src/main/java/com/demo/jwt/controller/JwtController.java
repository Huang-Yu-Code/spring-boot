package com.demo.jwt.controller;

import com.demo.jwt.entity.User;
import com.demo.jwt.service.JwtService;
import com.demo.jwt.util.JwtUtils;
import com.demo.jwt.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.demo.jwt.service.impl.JwtServiceImpl.USERS;

/**
 * 项目: spring-boot
 * 时间: 2021/11/14 22:46
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@Slf4j
public class JwtController {
    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/user")
    public Object get(@CookieValue("token") String token) {
        String uid = JwtUtils.getUid(token);
        return ResponseEntity.status(200).body(User.builder().username(uid).password(USERS.get(uid)).build());
    }

    @PostMapping("/logon")
    public Object logon(@RequestBody User user) {
        jwtService.logon(user.getUsername(), user.getPassword());
        return ResponseUtils.success();
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        String token = jwtService.login(user.getUsername(), user.getPassword());
        Map<String, Object> body = ResponseUtils.getBody(HttpStatus.OK);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, "token=" + token + ";HttpOnly=true;Secure=true")
                .body(body);
    }

    @PostMapping("/logout")
    public Object logout(@CookieValue("token") String token) {
        jwtService.logout(token);
        return ResponseUtils.success();
    }
}
