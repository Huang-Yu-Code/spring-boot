package com.github.codingob.session.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableJdbcHttpSession
@EnableTransactionManagement
public class SessionJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SessionJdbcApplication.class, args);
    }
}
