package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.Role;
import com.example.api.service.IRoleService;
import com.example.common.entity.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/roles")
@Slf4j
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService iRoleService;

    @PostMapping("")
    public R<Void> insert(@RequestBody Role entity) {
        iRoleService.save(entity);
        return R.success();
    }

    @GetMapping()
    public R<List<Role>> select(Role entity) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        Long id = entity.getId();
        String code = entity.getCode();
        String name = entity.getName();
        queryWrapper.eq(!ObjectUtils.isEmpty(id), "id", id)
                .eq(StringUtils.hasText(code), "code", code)
                .eq(StringUtils.hasText(name), "name", name);
        List<Role> list = iRoleService.list(queryWrapper);
        return R.success(list);
    }

    @PutMapping("")
    public R<Void> update(@RequestBody Role entity) {
        iRoleService.updateById(entity);
        return R.success();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        iRoleService.removeById(id);
        return R.success();
    }
}
