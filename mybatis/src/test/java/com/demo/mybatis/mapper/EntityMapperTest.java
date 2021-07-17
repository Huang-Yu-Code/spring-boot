package com.demo.mybatis.mapper;

import com.demo.mybatis.entity.Entity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class EntityMapperTest {
    @Autowired
    private EntityMapper entityMapper;

    @Test
    void create() {
        Entity entity = new Entity(1, "create", null, null, null);
        int i = entityMapper.create(entity);
        Assertions.assertEquals(1, i);
    }

    @Test
    void delete() {
        int i = entityMapper.deleteById(1);
        Assertions.assertEquals(1, i);
    }

    @Test
    void update() {
        Entity entity = new Entity(1, "update", null, null, null);
        int i = entityMapper.update(entity);
        Assertions.assertEquals(1, i);
    }

    @Test
    void getById() {
        Entity entity = entityMapper.getById(1);
        log.info(entity.toString());
        Assertions.assertNotNull(entity);
    }

    @Test
    void getList() {
        List<Entity> entityList = entityMapper.getList(0, 10);
        log.info(entityList.toString());
        Assertions.assertEquals(1, entityList.size());
    }
}
