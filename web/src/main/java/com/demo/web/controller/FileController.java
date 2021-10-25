package com.demo.web.controller;

import com.demo.web.service.FileService;
import com.demo.web.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目: spring-boot
 * 时间: 2021/10/20 15:34
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Object fileUpload(@RequestParam("json") String json, @RequestParam("files") MultipartFile[] multipartFiles) {
        fileService.upload(json, multipartFiles);
        return ResponseUtils.success(201,"上传成功");
    }

    @GetMapping("")
    public Object fileDownload() {
        fileService.download();
        return null;
    }
}
