package com.github.codingob.session.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Configuration
public class BeanConfig {
    @Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookiePath("/");
//        serializer.setDomainName("localhost.com");
        return serializer;
    }
}
