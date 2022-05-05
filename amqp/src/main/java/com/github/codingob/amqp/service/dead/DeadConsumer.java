package com.github.codingob.amqp.service.dead;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 死信队列
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class DeadConsumer {
    @RabbitListener(queues = {"dead.queue"})
    @RabbitHandler
    public void receive(String message) {
        log.info("死信队列: {}", message);
    }
}
