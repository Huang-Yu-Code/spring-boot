package com.example.system.service.impl;

import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.system.entity.Role;
import com.example.system.mapper.RoleMapper;
import com.example.system.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/4/4 23:18
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    private final RoleMapper mapper;

    @Override
    public Role select(Long id) {
        return mapper.select(id);
    }

    @Override
    public List<Role> selectList(Role entity) {
        return mapper.selectList(entity);
    }

    @Override
    public void insert(Role entity) {
        try {
            mapper.insert(entity);
        } catch (DuplicateKeyException e) {
            String message = e.getCause().getMessage();
            String[] strings = message.split("key");
            String s = strings[1].replace("'", "").trim();
            System.out.println(s);
            if ("role.unique_name".equals(s)) {
                throw new CommonException(StatusCode.ROLE_NAME_EXIST);
            }
            throw new CommonException(StatusCode.ROLE_CODE_EXIST);
        }
    }

    @Override
    public void update(Role entity) {
        mapper.update(entity);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}
