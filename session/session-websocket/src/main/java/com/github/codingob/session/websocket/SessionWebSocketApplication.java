package com.github.codingob.session.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableRedisHttpSession
public class SessionWebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(SessionWebSocketApplication.class, args);
    }
}
