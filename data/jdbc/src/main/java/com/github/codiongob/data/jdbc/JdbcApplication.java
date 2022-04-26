package com.github.codiongob.data.jdbc;

import com.github.codiongob.data.jdbc.dao.EntityDao;
import com.github.codiongob.data.jdbc.entity.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * 启动类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@Slf4j
public class JdbcApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JdbcApplication.class, args);
        context.registerShutdownHook();
        EntityDao entityDao = context.getBean("entityDao", EntityDao.class);

        Entity entity = new Entity("spring_jdbc", false);
        int i = entityDao.create(entity);
        log.info("插入成功: " + i);

        entity = entityDao.getById(1);
        log.info("查询成功: " + entity);

        List<Entity> entities = entityDao.getByList(1, 10);
        log.info("查询成功: " + entities);

        entity.setMoney(new BigDecimal(2000));
        i = entityDao.updateById(entity);
        log.info("修改成功: " + i);

        i = entityDao.deleteById(1);
        log.info("删除成功: " + i);
    }
}
