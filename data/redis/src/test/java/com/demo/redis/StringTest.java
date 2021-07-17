package com.demo.redis;

import com.demo.redis.entity.Entity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class StringTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void set() {
        stringRedisTemplate.opsForValue().set("姓名", "黄宇");
    }

    @Test
    void get() {
        stringRedisTemplate.opsForValue().get("key1");
    }

    @Test
    void append() {
        stringRedisTemplate.opsForValue().append("key1", "value2");
    }

    @Test
    void hasKey(){
        Boolean hasKey = redisTemplate.hasKey("key1");
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
    void getObject(){
        Entity entity = (Entity) redisTemplate.opsForValue().get("entity1");
        log.info(entity.toString());
    }
}
