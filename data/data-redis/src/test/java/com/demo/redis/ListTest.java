package com.demo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class ListTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void leftPush(){
        stringRedisTemplate.opsForList().leftPush("list1", "1");
    }

    @Test
    void rightPush(){
        stringRedisTemplate.opsForList().rightPush("list1", "3");
    }

}
