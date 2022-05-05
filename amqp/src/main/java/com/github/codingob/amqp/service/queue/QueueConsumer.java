package com.github.codingob.amqp.service.queue;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 简单队列(P2P)
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class QueueConsumer {

    @RabbitListener(queues = {"queue"})
    @RabbitHandler
    public void receive(String msg, Channel channel, Message message) {
        log.info("msg:{}---channel:{}---message:{}", msg, channel, message);
    }
}
