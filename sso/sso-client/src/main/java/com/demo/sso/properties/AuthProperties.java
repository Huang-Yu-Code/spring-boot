package com.demo.sso.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 项目: spring-boot
 * 时间: 2021/11/25 1:18
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@ConfigurationProperties(prefix = "auth-interceptor")
public class AuthProperties {
    private String[] pathPatterns = {"/**"};
    private String[] excludePathPatterns;

    public String[] getPathPatterns() {
        return pathPatterns;
    }

    public void setPathPatterns(String[] pathPatterns) {
        this.pathPatterns = pathPatterns;
    }

    public String[] getExcludePathPatterns() {
        return excludePathPatterns;
    }

    public void setExcludePathPatterns(String[] excludePathPatterns) {
        this.excludePathPatterns = excludePathPatterns;
    }
}
