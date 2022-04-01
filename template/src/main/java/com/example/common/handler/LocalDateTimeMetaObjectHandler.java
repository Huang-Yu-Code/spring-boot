package com.example.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 项目: template
 * 时间: 2022/3/31 17:41
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Component
public class LocalDateTimeMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createTime", LocalDateTime.class,LocalDateTime.now());
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
    }
}
