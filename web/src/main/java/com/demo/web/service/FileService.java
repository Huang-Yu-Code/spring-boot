package com.demo.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 项目: spring-boot
 * 时间: 2021/10/20 14:13
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
@Slf4j
public class FileService {

    private final HttpServletRequest request;

    public FileService(HttpServletRequest request) {
        this.request = request;
    }

    public void upload(String json, MultipartFile[] multipartFiles) {
        log.info("Token:{}", request.getHeader(HttpHeaders.AUTHORIZATION));
        log.info("Json:{},Files:{}", json, multipartFiles);
        Assert.notNull(multipartFiles, "文件为空");
        for (MultipartFile multipartFile: multipartFiles) {
            Assert.notNull(multipartFile,"文件为空");
            String originalFilename = multipartFile.getOriginalFilename();
            Assert.notNull(originalFilename,"文件名为空");
            try {
                multipartFile.transferTo(new File(originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("文件上传失败");
            }
        }
    }

    public void download() {

    }
}
