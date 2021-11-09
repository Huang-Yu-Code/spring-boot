package com.demo.web.service;

import com.demo.web.properties.CaptchaProperties;
import com.demo.web.util.CaptchaUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:36
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
public class CaptchaService {

    private final CaptchaProperties captchaProperties;

    private final HttpSession httpSession;

    public CaptchaService(CaptchaProperties captchaProperties, HttpSession httpSession) {
        this.captchaProperties = captchaProperties;
        this.httpSession = httpSession;
    }

    public Object getImage() {
        boolean number = captchaProperties.isNumber();
        int length = captchaProperties.getLength();
        String text = CaptchaUtils.getText(number, length);
        httpSession.setAttribute("captcha", text.toLowerCase());
        int width = captchaProperties.getWidth();
        int height = captchaProperties.getHeight();
        String format = captchaProperties.getFormat();
        return CaptchaUtils.getImage(width, height, format, text);
    }

    public void validText(String text) {
        Assert.notNull(text, "验证码不能为空");
        String sessionAttribute = (String) httpSession.getAttribute("captcha");
        Assert.isTrue(text.equals(sessionAttribute), "验证码错误");
    }
}
