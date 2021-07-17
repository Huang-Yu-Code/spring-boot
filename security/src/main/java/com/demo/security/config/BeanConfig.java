package com.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author codingob
 */
@Configuration
public class BeanConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userName -> {
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("user");
            return new org.springframework.security.core.userdetails.User(userName, passwordEncoder().encode("root"), authorities);
        };
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.sendRedirect("/home");
        };
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            String username = httpServletRequest.getParameter("username");
            String password = httpServletRequest.getParameter("password");
            String info;
            if (username == null || "".equals(username)) {
                info = "账号为空";
            }
            else {
                if (password == null || "".equals(password)) {
                    info = "密码为空";
                } else {
                    info = "账号或密码错误";
                }
            }
            httpServletResponse.getWriter().write(info);
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.sendRedirect("/login");
        };
    }

}
