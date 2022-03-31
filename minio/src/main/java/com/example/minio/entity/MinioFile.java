package com.example.minio.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * 项目: minio
 * 时间: 2022/3/25 3:15
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class MinioFile {
    private Long id;
    private String name;
    private String url;
    private LocalDateTime createTime;
    private MultipartFile file;
}
