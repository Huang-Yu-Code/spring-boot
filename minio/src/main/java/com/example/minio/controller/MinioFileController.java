package com.example.minio.controller;

import com.example.common.util.Response;
import com.example.minio.entity.MinioFile;
import com.example.minio.service.MinioFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.common.enums.ResponseCode.SUCCESS;

/**
 * 项目: Minio
 * 时间: 2022/2/16 1:25
 * Minio接口
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/minio")
public class MinioFileController {
    private final MinioFileService minioFileService;

    @PostMapping("/")
    public Response upload(@Validated MinioFile minioFile) {
        minioFileService.upload(minioFile);
        minioFile.setFile(null);
        return Response.success(SUCCESS, minioFile);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        minioFileService.delete(id);
        return Response.success(SUCCESS, null);
    }
}
