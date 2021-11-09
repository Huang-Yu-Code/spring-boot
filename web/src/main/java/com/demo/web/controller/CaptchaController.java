package com.demo.web.controller;

import com.demo.web.service.CaptchaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    private final CaptchaService captchaService;

    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @PostMapping("")
    public Object getImage() {
        Object image = captchaService.getImage();
        return ResponseEntity.ok(image);
    }

    @GetMapping("")
    public Object validText(@RequestParam("text") String text) {
        captchaService.validText(text);
        return null;
    }

    @GetMapping("/sss")
    public Object getShortMessage() {
        return null;
    }
}
