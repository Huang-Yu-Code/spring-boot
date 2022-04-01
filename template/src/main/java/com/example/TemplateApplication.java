package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * 项目: template
 * 时间: 2022/2/16 1:12
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.*.mapper")
@ConfigurationPropertiesScan
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
