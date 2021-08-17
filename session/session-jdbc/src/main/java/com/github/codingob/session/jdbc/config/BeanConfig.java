package com.github.codingob.session.jdbc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.sql.DataSource;

/**
 * Bean配置
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Configuration
public class BeanConfig {
    @Bean
    public DataSource dataSource(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        return new DriverManagerDataSource(url, username, password);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookiePath("/");
//        serializer.setDomainName("localhost.com");
        return serializer;
    }
}
