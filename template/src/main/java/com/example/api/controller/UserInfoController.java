package com.example.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.api.entity.UserInfo;
import com.example.api.service.IUserInfoService;
import com.example.common.entity.R;
import com.example.common.enums.StatusCode;
import com.example.common.exception.CommonException;
import com.example.common.util.MinioUtils;
import com.example.common.util.TokenUtils;
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
    private final TokenUtils tokenUtils;
    private final MinioUtils minioUtils;

    @PostMapping("")
    public R<Void> insert(@RequestBody UserInfo entity) {
        iUserInfoService.save(entity);
        return R.success();
    }

    @GetMapping("/")
    public R<UserInfo> select() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        Long userId = tokenUtils.getId();
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
        String upload = minioUtils.upload(multipartFile);
        entity.setImage(upload);
        iUserInfoService.updateById(entity);
        return R.success();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        iUserInfoService.removeById(id);
        return R.success();
    }

}
