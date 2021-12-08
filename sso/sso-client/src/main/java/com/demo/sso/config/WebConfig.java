package com.demo.sso.config;

import com.demo.sso.interceptor.AuthInterceptor;
import com.demo.sso.properties.AuthProperties;
import org.springframework.context.annotation.Configuration;
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

    private final AuthInterceptor authInterceptor;

    private final AuthProperties authProperties;

    public WebConfig(AuthInterceptor authInterceptor, AuthProperties authProperties) {
        this.authInterceptor = authInterceptor;
        this.authProperties = authProperties;
    }

    // 拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pathPatterns = authProperties.getPathPatterns();
        String[] excludePathPatterns = authProperties.getExcludePathPatterns();
        registry.addInterceptor(authInterceptor).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
