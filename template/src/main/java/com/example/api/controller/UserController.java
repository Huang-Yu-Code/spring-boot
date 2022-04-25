package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.User;
import com.example.api.service.IUserService;
import com.example.common.entity.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final IUserService service;

    @PostMapping("")
    public R<Void> insert(@RequestBody User entity) {
        entity.setState(1L);
        service.save(entity);
        return R.success();
    }

    @GetMapping()
    public R<List<User>> select(User entity) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Long id = entity.getId();
        String username = entity.getUsername();
        Long state = entity.getState();
        queryWrapper.eq(!ObjectUtils.isEmpty(id), "id", id)
                .eq(StringUtils.hasText(username), "username", username)
                .eq(!ObjectUtils.isEmpty(state), "state", state);
        queryWrapper.select("id", "username", "state", "create_time", "update_time");
        List<User> list = service.list(queryWrapper);
        return R.success(list);
    }

    @PutMapping("")
    public R<Void> update(@RequestBody User entity) {
        service.updateById(entity);
        return R.success();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        service.removeById(id);
        return R.success();
    }
}
