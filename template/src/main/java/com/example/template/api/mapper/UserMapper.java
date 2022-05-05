package com.example.template.api.mapper;

import com.example.template.api.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
