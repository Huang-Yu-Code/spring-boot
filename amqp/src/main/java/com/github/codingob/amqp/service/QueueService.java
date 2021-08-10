package com.github.codingob.amqp.service;

import com.github.codingob.amqp.entity.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */

@Service
@Slf4j
@RabbitListener(queues = "queue")
public class QueueService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void send(Object message) {
        rabbitTemplate.convertAndSend("queue", message);
        log.info("发送成功: " + message);
    }

    @RabbitHandler
    public void receive(Entity entity) {
        log.info("简单队列: " + entity);
    }
}
