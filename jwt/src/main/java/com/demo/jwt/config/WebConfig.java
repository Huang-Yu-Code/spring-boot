package com.demo.jwt.config;

import com.demo.jwt.interceptor.JwtInterceptor;
import com.demo.jwt.properties.JwtProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 项目: spring-boot
 * 时间: 2021/11/9 15:08
 * WebMvc配置
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;
    private final JwtProperties jwtProperties;

    public WebConfig(JwtInterceptor jwtInterceptor, JwtProperties jwtProperties) {
        this.jwtInterceptor = jwtInterceptor;
        this.jwtProperties = jwtProperties;
    }

    // 拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final String[] excludePathPatterns = {"/error", "/logon", "/login"};
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
    }

    // 跨域处理

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        final String[] methods = {"GET", "POST", "DELETE", "PUT", "PATCH"};
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods(methods)
                .allowCredentials(true);
    }
}
