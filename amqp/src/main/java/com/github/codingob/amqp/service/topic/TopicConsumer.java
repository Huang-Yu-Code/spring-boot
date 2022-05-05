package com.github.codingob.amqp.service.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 主题模式
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class TopicConsumer {
    @RabbitListener(queues = {"topic.queue.A"})
    @RabbitHandler
    public void receiveA(String message) {
        log.info("topic.queue.A:{} ", message);
    }

    @RabbitListener(queues = {"topic.queue.B"})
    @RabbitHandler
    public void receiveB(String message) {
        log.info("topic.queue.B:{} ", message);
    }
}
