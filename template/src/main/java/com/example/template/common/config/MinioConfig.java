package com.example.template.common.config;

import io.minio.MinioClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目: template
 * 时间: 2021/11/9 15:08
 * WebMvc配置
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */

@Configuration
@RequiredArgsConstructor
@Slf4j
@ConfigurationProperties(prefix = "minio")
@Getter
@Setter
public class MinioConfig {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucket;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
