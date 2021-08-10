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
@RabbitListener(queues = "work-fair")
public class WorkFairService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void send(Object message) {
        rabbitTemplate.convertAndSend("work-fair", message);
        log.info("发送成功: " + message);
    }

    @RabbitHandler
    public void receive(Entity entity) {
        log.info("工作队列1(公平): " + entity);
    }

    @RabbitHandler
    public void receive2(Entity entity) {
        log.info("工作队列2(公平): " + entity);
    }
}
