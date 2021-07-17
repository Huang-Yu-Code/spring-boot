package com.demo.mybatis.plus.mapper;

import com.demo.mybatis.plus.entity.Entity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@Slf4j
public class EntityMapperTest {
    @Autowired
    private EntityMapper entityMapper;

    @Test
    void insert() {
        Entity entity = new Entity();
        entity.setId(1);
        entity.setName("entity" + 1);
        entity.setGender(false);
        int i = entityMapper.insert(entity);
        Assertions.assertEquals(1, i);
    }

    @Test
    void SelectById(){
        Entity entity = entityMapper.selectById(1);
        log.info(entity.toString());
        Assertions.assertNotNull(entity);
    }

    @Test
    void deleteById(){
        int i = entityMapper.deleteById(1);
        Assertions.assertEquals(1, i);
    }

    @Test
    void updateById(){
        Entity entity = entityMapper.selectById(1);
        entity.setName("update");
        entity.setMoney(new BigDecimal(1000));
        int i = entityMapper.updateById(entity);
        Assertions.assertEquals(1, i);
    }
}
