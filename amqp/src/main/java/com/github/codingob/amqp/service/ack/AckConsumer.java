package com.github.codingob.amqp.service.ack;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 死信队列
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class AckConsumer {
    private int num = 1;

    @RabbitListener(queues = {"ack.queue"}, ackMode = "MANUAL")
    @RabbitHandler
    public void receive(String msg, Channel channel, Message message) throws IOException {
        try {
            int i = 1 / 0;
            log.error("ack.queue: " + msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            if (num < 4) {
                // 拒绝确认消息
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                log.error("消息已拒绝确认,重回队列---" + num);
                num++;
            } else {
                // 拒绝消息
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                log.error("消息已拒绝,从队列中删除");
                num = 0;
            }
        }
    }
}
