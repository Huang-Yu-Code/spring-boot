package com.example.minio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目: minio
 * 时间: 2022/2/16 1:12
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.minio.mapper")
public class MinioApplication {
    public static void main(String[] args) {
        SpringApplication.run(MinioApplication.class, args);
    }
}
