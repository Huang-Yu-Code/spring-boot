package com.demo.sso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 项目: spring-boot
 * 时间: 2021/11/22 16:32
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
public class UserController {
    @GetMapping("/users/{id}")
    public Object get(@PathVariable String id){
        return ResponseEntity.status(200).body(new HashMap<>(0));
    }
}
