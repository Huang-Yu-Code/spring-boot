package com.example.mybatis.mapper;

import com.example.mybatis.entity.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 项目: mybatis
 * 时间: 2022/5/11 15:04
 * RoleMapper测试类
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootTest
@Slf4j
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2L);
        userInfo.setName("insertTest");
        userInfo.setImage("image");
        userInfo.setIdNumbers("idNumbers");
        userInfo.setPhoneNumbers("1234567890");
        userInfo.setEmail("email");
        int rows = userInfoMapper.insert(userInfo);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void select() {
        PageHelper.startPage(1,2);
        List<UserInfo> userInfos = userInfoMapper.select();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);
        log.info("{}", userInfos);
        log.info("{}", pageInfo);
        Assertions.assertNotNull(userInfos);
    }

    @Test
    void selectOne() {
        UserInfo userInfo = userInfoMapper.selectOne(1L);
        log.info("{}", userInfo);
        Assertions.assertNotNull(userInfo);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2L);
        userInfo.setName("updateTest");
        userInfo.setImage("image");
        userInfo.setIdNumbers("idNumbers");
        userInfo.setPhoneNumbers("1234567890");
        userInfo.setEmail("email");
        int rows = userInfoMapper.update(userInfo);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void delete() {
        int rows = userInfoMapper.delete(2L);
        Assertions.assertEquals(1, rows);
    }
}
