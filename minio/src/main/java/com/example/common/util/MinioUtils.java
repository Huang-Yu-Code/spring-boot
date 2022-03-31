package com.example.common.util;

import com.example.common.config.MinioConfig;
import com.example.common.exception.CommonException;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * 项目: minio
 * 时间: 2021/11/9 15:08
 * Minio工具类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class MinioUtils {
    private final MinioConfig minioConfig;
    private final MinioClient minioClient;

    public void makeBucket() {
        try {
            String bucket = minioConfig.getBucket();
            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }
        } catch (Exception e) {
            log.error("文件服务器异常:", e);
            throw new CommonException("文件服务器异常");
        }
    }

    public String upload(MultipartFile multipartFile) {
        try {
            makeBucket();
            String bucket = minioConfig.getBucket();
            String endpoint = minioConfig.getEndpoint();
            String filename = multipartFile.getOriginalFilename();
            Assert.notNull(filename, "文件名为空");
            int index = filename.lastIndexOf(".") + 1;
            String object = String.format("%s.%s", UUID.randomUUID(), filename.substring(index));
            InputStream inputStream = multipartFile.getInputStream();
            long size = multipartFile.getSize();
            String contentType = multipartFile.getContentType();
            minioClient.putObject(PutObjectArgs.builder().bucket(bucket).object(object).stream(inputStream, size, -1).contentType(contentType).build());
            return String.format("%s/%s/%s", endpoint, bucket, object);
        } catch (Exception e) {
            log.error("文件上传异常:", e);
            throw new CommonException("文件上传异常");
        }
    }

    public void delete(String url) {
        try {
            String bucket = minioConfig.getBucket();
            String object = url.split(bucket)[1];
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(object).build());
        } catch (Exception e) {
            log.error("文件删除异常:", e);
            throw new CommonException("文件删除异常");
        }
    }
}
