package com.example.common.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 项目: spring-boot
 * 时间: 2022/4/20 1:27
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://server:3306/spring_boot";
        String username = "root";
        String password = "root";
        String author = "黄宇";
        String outputDir = "D:/github/java/spring-boot/template";
        String parent = "com.example.api";
        String moduleName = "";
        String[] tables = {"role", "user", "user_role", "user_info"};
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder.author(author)
                        .fileOverride()
                        .disableOpenDir()
                        .dateType(DateType.TIME_PACK)
                        .outputDir(outputDir + "/src/main/java"))
                .packageConfig(builder -> builder
                        .parent(parent)
                        .moduleName(moduleName)
                        .pathInfo(Collections.singletonMap(OutputFile.xml, outputDir + "/src/main/resources/mapper/api")))
                .strategyConfig(builder -> builder
                        .addInclude(tables)
                        .mapperBuilder()
                        .enableMapperAnnotation()
                        .entityBuilder()
                        .controllerBuilder()
                        .enableRestStyle()
                        .enableHyphenStyle())
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
