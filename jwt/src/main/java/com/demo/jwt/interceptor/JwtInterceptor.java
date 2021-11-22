package com.demo.jwt.interceptor;

import com.demo.jwt.properties.JwtProperties;
import com.demo.jwt.util.JwtUtils;
import com.demo.jwt.util.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.demo.jwt.service.impl.JwtServiceImpl.TOKENS;

/**
 * 项目: spring-boot
 * 时间: 2021/11/14 22:33
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    private final ObjectMapper objectMapper;
    private final JwtProperties jwtProperties;

    public JwtInterceptor(ObjectMapper objectMapper, JwtProperties jwtProperties) {
        this.objectMapper = objectMapper;
        this.jwtProperties = jwtProperties;
    }

    private boolean response(HttpServletResponse response, String error) throws IOException {
        response.setStatus(401);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String body = objectMapper.writeValueAsString(ResponseUtils.getBody(HttpStatus.UNAUTHORIZED, error));
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.getWriter().write(body);
        response.flushBuffer();
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return response(response, "禁止访问");
        }
        Arrays.stream(cookies).forEach(System.out::println);
        if (cookies == null) {
            return response(response, "禁止访问");
        } else {
            List<Cookie> list = Arrays.stream(cookies)
                    .filter(cookie -> "token".equals(cookie.getName()))
                    .collect(Collectors.toList());
            if (list.isEmpty()) {
                log.info("list:{}", list);
                return response(response, "非法令牌");
            }
            String token = list.get(0).getName();
            try {
                String signature = jwtProperties.getSignature();
                JwtUtils.checkToken(signature, token);
                if (!TOKENS.containsKey(token)) {
                    return response(response, "令牌不存在");
                }
            } catch (ExpiredJwtException e) {
                TOKENS.remove(token);
                return response(response, "令牌已过期");
            } catch (UnsupportedJwtException | MalformedJwtException | SignatureException e) {
                return response(response, "非法令牌");
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
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
