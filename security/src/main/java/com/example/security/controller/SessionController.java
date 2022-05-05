package com.example.security.controller;

import com.example.security.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Service
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class SessionController {
    private final SessionService service;
    private final HttpServletRequest request;

    @GetMapping("/")
    public String get() {
        return "Get session username is: " + service.getUsername(request.getSession());
    }

    @GetMapping("/set")
    public String set() {
        service.setUsername(request.getSession());
        return "Set session username ok!";
    }
}
