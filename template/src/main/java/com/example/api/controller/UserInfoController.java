package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.UserInfo;
import com.example.api.service.IUserInfoService;
import com.example.common.entity.Response;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author 黄宇
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/user-info")
@Slf4j
@RequiredArgsConstructor
public class UserInfoController {
    private final IUserInfoService service;
    private final TokenUtils tokenUtils;

    @PostMapping("")
    public Response<Void> insert(@RequestBody UserInfo entity) {
        service.save(entity);
        return Response.success();
    }

    @GetMapping("/")
    public Response<UserInfo> select() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        Long userId = tokenUtils.getId();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId);
        UserInfo userInfo = service.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new CommonException(StatusCode.USERINFO_NO_EXIST);
        }
        return Response.success(userInfo);
    }

    @GetMapping("")
    public Response<List<UserInfo>> select(UserInfo entity) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        Long id = entity.getId();
        Long userId = entity.getUserId();
        String name = entity.getName();
        String image = entity.getImage();
        String idNumbers = entity.getIdNumbers();
        String phoneNumbers = entity.getPhoneNumbers();
        queryWrapper.eq(!ObjectUtils.isEmpty(id), "id", id)
                .eq(!ObjectUtils.isEmpty(userId), "user_id", userId)
                .eq(StringUtils.hasText(name), "name", name)
                .eq(StringUtils.hasText(image), "image", image)
                .eq(StringUtils.hasText(idNumbers), "id_numbers", idNumbers)
                .eq(StringUtils.hasText(phoneNumbers), "phone_numbers", phoneNumbers);
        List<UserInfo> list = service.list(queryWrapper);
        return Response.success(list);
    }

    @PutMapping("")
    public Response<Void> update(@RequestBody UserInfo entity) {
        service.updateById(entity);
        return Response.success();
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id) {
        service.removeById(id);
        return Response.success();
    }

}
