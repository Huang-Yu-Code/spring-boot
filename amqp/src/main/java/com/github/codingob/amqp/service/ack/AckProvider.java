package com.github.codingob.amqp.service.ack;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
public class AckProvider {
    @Autowired
    private RabbitTemplate rabbitTemplate;
}
