package com.github.codiongob.data.jdbc;

import com.github.codiongob.data.jdbc.dao.EntityDao;
import com.github.codiongob.data.jdbc.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DataJdbcApplication {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataJdbcApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DataJdbcApplication.class, args);
        context.registerShutdownHook();
        EntityDao entityDao = context.getBean("entityDao", EntityDao.class);

        Entity entity = new Entity("spring_jdbc", false);
        int i = entityDao.create(entity);
        LOGGER.info("插入成功: " + i);

        entity = entityDao.getById(1);
        LOGGER.info("查询成功: " + entity);

        List<Entity> entities = entityDao.getByList(1, 10);
        LOGGER.info("查询成功: " + entities);

        entity.setMoney(new BigDecimal(2000));
        i = entityDao.updateById(entity);
        LOGGER.info("修改成功: " + i);

        i = entityDao.deleteById(1);
        LOGGER.info("删除成功: " + i);
    }
}
