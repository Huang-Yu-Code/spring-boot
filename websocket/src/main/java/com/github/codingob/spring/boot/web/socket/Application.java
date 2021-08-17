package com.github.codingob.spring.boot.web.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableWebSocketMessageBroker
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
