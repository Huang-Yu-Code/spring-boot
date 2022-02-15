package demo.web.controller;

import demo.web.service.CaptchaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")
    public Object get(){
        byte[] bytes = captchaService.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .header(HttpHeaders.CACHE_CONTROL,"no-store")
                .header(HttpHeaders.PRAGMA,"no-cache")
                .body(bytes);
    }
}
