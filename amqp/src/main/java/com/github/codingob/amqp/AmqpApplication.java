package com.github.codingob.amqp;

import com.github.codingob.amqp.service.Provider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableRabbit
@Slf4j
public class AmqpApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AmqpApplication.class, args);
        RabbitTemplate rabbitTemplate = applicationContext.getBean("rabbitTemplate", RabbitTemplate.class);
        Provider provider = applicationContext.getBean("provider", Provider.class);
        provider.sendQueue("queue", "这是游戏消息队列信息");
        rabbitTemplate.setReturnsCallback(returnedMessage -> log.info("消息路由失败!,返回消息:{}", returnedMessage));
        rabbitTemplate.setConfirmCallback((correlationData, b, s) -> {
            if (b) {
                log.info("消息投递成功");
            } else {
                log.info("消息投递失败 " + s);
            }
        });
        provider.sendQueue("queue1", "message");
        provider.sendQueue("", "ack.queue", "ack.queue", "1");
    }
}
