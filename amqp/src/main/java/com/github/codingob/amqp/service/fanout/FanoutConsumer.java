package com.github.codingob.amqp.service.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 广播模式
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class FanoutConsumer {
    @RabbitListener(queues = {"fanout.queue.A"})
    @RabbitHandler
    public void receiveA(String message) {
        log.info("fanout.queue.A:{} ", message);
    }

    @RabbitListener(queues = {"fanout.queue.B"})
    @RabbitHandler
    public void receiveB(String message) {
        log.info("fanout.queue.B:{} ", message);
    }
}
