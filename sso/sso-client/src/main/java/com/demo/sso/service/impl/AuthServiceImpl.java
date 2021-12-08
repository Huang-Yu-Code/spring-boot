package com.demo.sso.service.impl;

import com.demo.sso.dto.Login;
import com.demo.sso.dto.Logon;
import com.demo.sso.properties.TokenProperties;
import com.demo.sso.service.AuthService;
import com.demo.sso.util.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 项目: spring-boot
 * 时间: 2021/11/22 16:27
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    private static final String TOKEN = "token";

    private final HttpSession session;
    private final HttpServletResponse response;
    private final TokenProperties tokenProperties;

    public AuthServiceImpl(HttpSession session, HttpServletResponse response, TokenProperties tokenProperties) {
        this.session = session;
        this.response = response;
        this.tokenProperties = tokenProperties;
    }

    @Override
    public Object logon(Logon logon) {
        return null;
    }

    @Override
    public Object login(Login login) {
        log.info("{}", login);
        String username = login.getUsername();
        String password = login.getPassword();
        String captcha = login.getCaptcha();
        Boolean remember = login.getRemember();
        String issuer = tokenProperties.getIssuer();
        String audience = tokenProperties.getAudience();
        String subject = tokenProperties.getSubject();
        int expiration = tokenProperties.getExpiration();
        String signature = tokenProperties.getSignature();
        String token = TokenUtils.createToken(issuer, audience, subject, expiration, signature, username);
        session.setAttribute(TOKEN, token);
        if (remember) {
            Cookie cookie = new Cookie(TOKEN, token);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(expiration);
            response.addCookie(cookie);
        }
        return null;
    }

    @Override
    public void logout() {
        session.removeAttribute(TOKEN);
        Cookie cookie = new Cookie(TOKEN, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
