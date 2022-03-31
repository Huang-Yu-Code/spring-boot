package com.example.minio.service;

import com.example.minio.entity.MinioFile;

/**
 * 项目: minio
 * 时间: 2022/3/24 23:18
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public interface MinioFileService {

    void upload(MinioFile minioFile);

    void delete(Long id);
}
