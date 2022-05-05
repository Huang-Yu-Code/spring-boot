package com.example.template.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.template.api.entity.UserInfo;
import com.example.template.api.service.IUserInfoService;
import com.example.template.common.entity.R;
import com.example.template.common.enums.StatusCode;
import com.example.template.common.exception.CommonException;
import com.example.template.common.util.JwtUtils;
import com.example.template.common.util.MinioUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/user-infos")
@Slf4j
@RequiredArgsConstructor
public class UserInfoController {
    private final IUserInfoService iUserInfoService;
    private final JwtUtils jwtUtils;
    private final MinioUtils minioUtils;

    @PostMapping("")
    public R<Void> insert(@RequestBody UserInfo entity) {
        iUserInfoService.save(entity);
        return R.success();
    }

    @GetMapping("/")
    public R<UserInfo> select() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        Long userId = jwtUtils.getId();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId);
        UserInfo userInfo = iUserInfoService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new CommonException(StatusCode.USERINFO_NO_EXIST);
        }
        return R.success(userInfo);
    }

    @GetMapping("")
    public R<List<UserInfo>> select(UserInfo entity) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        Long userId = entity.getUserId();
        String name = entity.getName();
        String image = entity.getImage();
        String idNumbers = entity.getIdNumbers();
        String phoneNumbers = entity.getPhoneNumbers();
        queryWrapper.eq(!ObjectUtils.isEmpty(userId), "user_id", userId)
                .eq(StringUtils.hasText(name), "name", name)
                .eq(StringUtils.hasText(image), "image", image)
                .eq(StringUtils.hasText(idNumbers), "id_numbers", idNumbers)
                .eq(StringUtils.hasText(phoneNumbers), "phone_numbers", phoneNumbers);
        List<UserInfo> list = iUserInfoService.list(queryWrapper);
        return R.success(list);
    }

    @PutMapping("")
    public R<Void> update(@RequestParam(value = "file", required = false) MultipartFile multipartFile, UserInfo entity) {
        if (!ObjectUtils.isEmpty(multipartFile)) {
            String image = entity.getImage();
            String upload = minioUtils.upload(multipartFile);
            entity.setImage(upload);
            minioUtils.delete(image);
        }
        iUserInfoService.updateById(entity);
        return R.success();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        iUserInfoService.removeById(id);
        return R.success();
    }

}
