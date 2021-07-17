package com.demo.session.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author codingob
 */
@RestController
public class SessionController {

    @Value("${spring.application.name}")
    private String service;

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String index() {
        return service + "---" + port;
    }

    @GetMapping("/set/{key}/{value}")
    public String setSession(HttpServletRequest request, @PathVariable String key, @PathVariable String value) {
        request.getSession().setAttribute(key, value);
        return "key: " + key + "---" + "value: " + value + "---" + "sessionId: " + request.getSession().getId();
    }

    @GetMapping("/get/{key}")
    public String getSession(HttpServletRequest request, @PathVariable String key) {
        String value = (String) request.getSession().getAttribute(key);
        return "key: " + key + "---" + "value: " + value + "---" + "sessionId: " + request.getSession().getId();
    }

    @GetMapping("/logout")
    public String destroy(HttpServletRequest request) {
        String id = request.getSession().getId();
        request.getSession().invalidate();
        return "sessionId: " + id + "已注销";
    }
}
