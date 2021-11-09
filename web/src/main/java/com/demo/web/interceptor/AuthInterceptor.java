package com.demo.web.interceptor;

import com.demo.web.util.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

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

    private final ObjectMapper mapper;

    public AuthInterceptor(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行静态资源
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 认证
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (null == token || "null".equals(token)) {
            int status = HttpStatus.UNAUTHORIZED.value();
            response.setStatus(status);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(mapper.writeValueAsString(ResponseUtils.failure(status, "非法访问")));
            return false;
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
