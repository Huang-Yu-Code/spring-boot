package com.github.codingob.amqp.service.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 路由模式
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class DirectConsumer {
    @RabbitListener(queues = {"direct.queue.A"})
    @RabbitHandler
    public void receive1(String message) {
        log.info("direct.queue.A:{} ", message);
    }

    @RabbitListener(queues = {"direct.queue.B"})
    @RabbitHandler
    public void receive2(String message) {
        log.info("direct.queue.B:{} ", message);
    }
}
