package com.example.system.controller;

import com.example.common.enums.StatusCode;
import com.example.system.entity.Response;
import com.example.system.entity.Role;
import com.example.system.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目: template
 * 时间: 2022/3/31 23:10
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("")
    public Response list(Role role) {
        List<Role> roles = roleService.list(role);
        return Response.success(StatusCode.SUCCESS, roles);
    }

    @PostMapping("")
    public Response insert(@RequestBody Role role) {
        roleService.insert(role);
        return Response.success();
    }

    @PutMapping("")
    public Response update(@RequestBody Role role) {
        roleService.update(role);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable long id){
        roleService.delete(id);
        return Response.success();
    }
}
