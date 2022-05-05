package com.github.codingob.amqp.service.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 工作队列
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class WorkConsumer {
    @RabbitListener(queues = {"work.queue.fair"})
    @RabbitHandler
    public void receiveFair1(String message) {
        log.info("work.queue.fair.1:{} ", message);
    }

    @RabbitListener(queues = {"work.queue.fair"})
    @RabbitHandler
    public void receiveFair2(String message) {
        service();
        log.info("work.queue.fair.2:{} ", message);
    }

    @RabbitListener(queues = {"work.queue.loop"})
    @RabbitHandler
    public void receiveLoop1(String message) {
        service();
        log.info("work.queue.loop.1:{} ", message);
    }

    @RabbitListener(queues = {"work.queue.loop"})
    @RabbitHandler
    public void receiveLoop2(String message) {
        service();
        log.info("work.queue.loop.2:{} ", message);
    }

    private void service() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
