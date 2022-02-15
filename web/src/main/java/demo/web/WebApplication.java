package demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:36
 * war包启动类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class WebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
