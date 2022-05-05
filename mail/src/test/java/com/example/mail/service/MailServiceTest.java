package com.example.mail.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 项目: mail
 * 时间: 2021/11/14 20:59
 * 测试类
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
class MailServiceTest {
    String email = "13713507941@163.com";
    String subject = "测试主题";
    String text = "测试正文";
    String html = "<html><body><a href='https://spring.io/'>百度一下</a><img src='cid:%s'></body></html>";
    String file = "file/mail.png";
    @Autowired
    private MailService mailService;

    @Test
    void sendText() {
        mailService.sendText(email, subject, text);
    }

    @Test
    void sendHtml() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(this.file);
        File file = classPathResource.getFile();
        HashMap<String, File> files = new HashMap<>();
        files.put(this.file, file);
        mailService.sendHtml(email, subject, html, files);
    }

    @Test
    void sendFile() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(this.file);
        File file = classPathResource.getFile();
        HashMap<String, File> files = new HashMap<>();
        files.put(this.file, file);
        mailService.sendFile(email, subject, text, files);
    }
}
