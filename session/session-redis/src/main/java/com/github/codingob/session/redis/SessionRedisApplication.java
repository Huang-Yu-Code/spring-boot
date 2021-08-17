package com.github.codingob.session.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 启动类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableRedisHttpSession
public class SessionRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SessionRedisApplication.class, args);
    }
}
