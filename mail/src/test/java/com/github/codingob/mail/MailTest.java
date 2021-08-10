package com.github.codingob.mail;

import com.github.codingob.mail.service.MimeMessageHelperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/** 测试类
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class MailTest {
    @Autowired
    private MimeMessageHelperService mimeMessageHelperService;

    String mail = "13713507941@163.com";
    String subject = "测试主题";
    String text = "测试正文";
    String file = "mail.png";

    @Test
    void sendMail() {
        mimeMessageHelperService.sendMail(mail, subject, text, file);
    }
}
