package com.demo.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author codingob
 */
@Service
public class WebService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    public String index() {
        return applicationName + "---" + port;
    }
}
