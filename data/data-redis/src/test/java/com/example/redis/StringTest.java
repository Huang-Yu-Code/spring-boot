package com.example.redis;

import com.example.redis.entity.Entity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.math.BigDecimal;

@SpringBootTest
@Slf4j
class StringTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void set() {
        stringRedisTemplate.opsForValue().set("name", "黄宇");
    }

    @Test
    void get() {
        String name = stringRedisTemplate.opsForValue().get("name");
        Assertions.assertEquals("黄宇", name);
        log.info(name);
    }

    @Test
    void append() {
        stringRedisTemplate.opsForValue().append("name", "value2");
    }

    @Test
    void hasKey() {
        Boolean hasKey = redisTemplate.hasKey("name");
        Assertions.assertEquals(true, hasKey);
    }

    @Test
    void setObject() {
        Entity entity = new Entity();
        entity.setId(1);
        entity.setName("用户");
        entity.setGender(false);
        entity.setMoney(new BigDecimal(10000));
        redisTemplate.opsForValue().set("用户", entity);
    }

    @Test
    void getObject() {
        Entity entity = (Entity) redisTemplate.opsForValue().get("用户");
        log.info("entity:{}", entity);
    }
}
