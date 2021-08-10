package com.demo.web.controller;

import com.demo.web.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Controller
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Controller
public class WebController {

    private WebService service;

    @Autowired
    public void setWebService(WebService service) {
        this.service = service;
    }

    /**
     * 首页
     *
     * @return 首页视图
     */
    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "index";
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @return Void
     */
    @PostMapping("/home/upload")
    @ResponseBody
    public ResponseEntity<Void> upload(@RequestParam("file") CommonsMultipartFile file) {
        service.upload(file, "D:/");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 文件下载
     *
     * @return 文件流
     */
    @GetMapping("/home/download")
    @ResponseBody
    public ResponseEntity<byte[]> download() {
        String path = "static/";
        String file = "spring.png";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file);
        return new ResponseEntity<>(service.download(path + file), headers, HttpStatus.OK);
    }
}
