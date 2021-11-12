package com.demo.web.interceptor;

import com.demo.web.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 项目: spring-boot
 * 时间: 2021/11/12 17:57
 *
 * @author HuangYu
 * @version 1.0.0
 * @since JDK1.8
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        long uid = JwtUtils.getUid(token);

        String host = request.getRemoteHost();
        String url = request.getRequestURI();
        String method = request.getMethod();
        String args = null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
