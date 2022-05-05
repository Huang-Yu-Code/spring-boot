package com.github.codingob.amqp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
public class Provider {
    private final RabbitTemplate rabbitTemplate;

    public void sendQueue(String routingKey, Object object) {
        rabbitTemplate.convertAndSend(routingKey, object);
    }

    public void sendQueue(String exchange, String routingKey, Object object, String id) {
        rabbitTemplate.convertAndSend(exchange, routingKey, object, new CorrelationData(id));
    }
}
