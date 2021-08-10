package com.github.codingob.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Bean配置
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Configuration
public class BeanConfig {
    @Bean
    public Queue queue() {
        return new Queue("queue", true, false, false);
    }

    @Bean
    public Queue workFair() {
        return new Queue("work-fair", true, false, false);
    }

    @Bean
    public Queue workLoop() {
        return new Queue("work-loop", true, false, false);
    }
}
