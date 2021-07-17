package com.demo.mongodb;

import com.demo.mongodb.entity.Entity;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
@Slf4j
public class MongoDBTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void insert() {
        Entity entity = new Entity();
        entity.setId(1);
        entity.setName("黄宇");
        entity.setGender(false);
        entity.setMoney(new BigDecimal(1000));
        entity.setCreateTime(new Timestamp(new Date().getTime()));
        Entity insert = mongoTemplate.insert(entity);
        log.info(insert.toString());
    }

    @Test
    void findById() {
        Entity entity = mongoTemplate.findById(1, Entity.class);
        if (entity != null) log.info(entity.toString());
    }

    @Test
    void find() {
        // 模糊查找
        String regex = String.format("%s%s%s", ".^*", "黄宇", ".*$");
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Criteria criteria = Criteria.where("name").regex(pattern);
//        精确查找
//        Criteria criteria = Criteria.where("name").is("黄宇").and("money").is(new BigDecimal(1000));
        Query query = new Query();
        query.addCriteria(criteria);
        List<Entity> entities = mongoTemplate.find(query, Entity.class);
        log.info(entities.toString());
    }

    @Test
    void findAll() {
        List<Entity> entities = mongoTemplate.findAll(Entity.class);
        log.info(entities.toString());
    }

    @Test
    void upsert() {
        Query query = new Query(Criteria.where("id").is(2));
        Update update = new Update();
        update.set("name", "MongoDB");
        update.set("money", new BigDecimal(2000));
        UpdateResult result = mongoTemplate.upsert(query, update, Entity.class);
        log.info(result.toString());
    }

    @Test
    void delete() {
        Query query = new Query(Criteria.where("id").is(1));
        DeleteResult result = mongoTemplate.remove(query, Entity.class);
        log.info(result.toString());
    }
}
