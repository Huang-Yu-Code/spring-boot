package com.github.codingob.amqp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

/**
 * 测试类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
public class AmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @BeforeEach
    void config(){
        rabbitTemplate.setReturnsCallback(returnedMessage -> {
            System.out.println("消息路由失败!");
            System.out.println(returnedMessage);
        });
        rabbitTemplate.setConfirmCallback((correlationData, b, s) -> {
            if (b) {
                System.out.println("消息投递成功");
            } else {
                System.out.println("消息投递失败 " + s);
            }
        });
    }

    @Test
    void queue(){
        rabbitTemplate.convertAndSend("queue1","message");
    }


    @Test
    void sendACK(){
        rabbitTemplate.convertAndSend("","ack.queue","ack.queue",new CorrelationData("1"));
    }

}
