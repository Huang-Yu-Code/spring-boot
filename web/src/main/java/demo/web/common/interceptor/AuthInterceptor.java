package demo.web.common.interceptor;

import demo.web.common.properties.JwtProperties;
import demo.web.common.util.JwtUtils;
import demo.web.common.util.ResponseUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    private final JwtProperties jwtProperties;
    private final ObjectMapper mapper;

    public AuthInterceptor(JwtProperties jwtProperties, ObjectMapper mapper) {
        this.jwtProperties = jwtProperties;
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
        String signature = jwtProperties.getSignature();
        try {
            JwtUtils.checkToken(signature, token);
            return HandlerInterceptor.super.preHandle(request, response, handler);
        } catch (Exception e) {
            String msg = "无效Token";
            if (e instanceof ExpiredJwtException) {
                msg = "Token已过期";
            }
            if (e instanceof UnsupportedJwtException) {
                msg = "无效Token";
            }
            if (e instanceof MalformedJwtException) {
                msg = "无效Token";
            }
            if (e instanceof SignatureException) {
                msg = "无效Token";
            }
            if (e instanceof IllegalArgumentException) {
                msg = "无效Token";
            }
            HttpStatus status = HttpStatus.UNAUTHORIZED;
            response.setStatus(status.value());
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            Map<String, Object> map = ResponseUtils.getBody(status, msg);
            response.getWriter().write(mapper.writeValueAsString(map));
            return false;
        }
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
