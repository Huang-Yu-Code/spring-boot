package com.demo.web.controller;

import com.demo.web.service.WebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author codingob
 */
@RestController
public class WebController {

    @Resource
    private WebService webService;

    @GetMapping("/")
    public String index(){
        return webService.index();
    }
}
