package com.github.codingob.amqp;

import com.github.codingob.amqp.entity.Entity;
import com.github.codingob.amqp.service.QueueService;
import com.github.codingob.amqp.service.WorkFairService;
import com.github.codingob.amqp.service.WorkLoopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
public class AmqpTest {
    @Autowired
    private QueueService queueService;

    @Autowired
    private WorkFairService workFairService;

    @Autowired
    private WorkLoopService workLoopService;

    @Test
    void queueService() {
        Entity entity = new Entity(1L, "rabbitmq");
        queueService.send(entity);
    }

    @Test
    void workFairService() {
        for (long i = 0L; i < 10; i++) {
            Entity entity = new Entity(i, "rabbitmq");
            workFairService.send(entity);
        }
    }

    @Test
    void workLoopService() {
        for (long i = 0L; i < 10; i++) {
            Entity entity = new Entity(i, "rabbitmq");
            workLoopService.send(entity);
        }
    }
}
