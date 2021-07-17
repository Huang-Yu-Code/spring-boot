package com.demo.mybatis.mapper;

import com.demo.mybatis.entity.Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yu
 */
@Mapper
public interface EntityMapper {

    int create(Entity entity);

    int deleteById(@Param("id") int id);

    Entity getById(@Param("id") int id);

    List<Entity> getList(@Param("page") int page,@Param("size") int size);

    int update(Entity entity);
}
