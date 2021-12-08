package com.demo.sso.interceptor;

import com.demo.sso.properties.TokenProperties;
import com.demo.sso.util.ResponseUtils;
import com.demo.sso.util.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 * 认证拦截器
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final String TOKEN = "token";
    private final TokenProperties tokenProperties;
    private final ObjectMapper objectMapper;

    public AuthInterceptor(TokenProperties tokenProperties, ObjectMapper objectMapper) {
        this.tokenProperties = tokenProperties;
        this.objectMapper = objectMapper;
    }

    private void response(HttpServletResponse response, String error) throws Exception {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        response.setStatus(status.value());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Map<String, Object> body = ResponseUtils.getBody(status, error);
        response.getWriter().write(objectMapper.writeValueAsString(body));
    }

    private void checkToken(String token){

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        HttpSession session = request.getSession();
        token = (String) session.getAttribute(TOKEN);
        String error = "未找到令牌信息";
        if (token == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (TOKEN.equals(name)) {
                    session.setAttribute(name, value);
                    return true;
                }
            }
        } else {
            try {
                String signature = tokenProperties.getSignature();
                TokenUtils.checkToken(signature, token);
                return true;
            } catch (ExpiredJwtException e) {
                error = "失效令牌";
            } catch (UnsupportedJwtException e) {
                error = "无效令牌";
            } catch (MalformedJwtException e) {
                error = "错误令牌";
            } catch (SignatureException e) {
                error = "令牌签名错误";
            }
        }
        response(response, error);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
