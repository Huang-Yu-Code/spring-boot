package com.demo.web.controller;

import com.demo.web.entity.File;
import com.demo.web.service.FileService;
import com.demo.web.util.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class FileController {

    private final FileService fileService;

    private final ObjectMapper objectMapper;

    public FileController(FileService fileService, ObjectMapper objectMapper) {
        this.fileService = fileService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "")
    public Object addFile(@RequestParam("json") String json, @RequestPart("file") MultipartFile multipartFile) throws JsonProcessingException {
        File file = objectMapper.readValue(json, File.class);
        file = fileService.addFile(file, multipartFile);
        return ResponseUtils.success(file);
    }

    @GetMapping("{id}")
    public Object getFile(@PathVariable long id) {
        fileService.download();
        return ResponseUtils.success();
    }

    @GetMapping("")
    public Object getFiles() {
        fileService.download();
        return ResponseUtils.success();
    }

    @DeleteMapping("{id}")
    public Object deleteFile(@PathVariable long id){
        return ResponseUtils.success(204,null);
    }
}
