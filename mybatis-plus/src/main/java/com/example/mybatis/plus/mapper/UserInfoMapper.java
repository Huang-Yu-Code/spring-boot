package com.example.mybatis.plus.mapper;

import com.example.mybatis.plus.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-20
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
