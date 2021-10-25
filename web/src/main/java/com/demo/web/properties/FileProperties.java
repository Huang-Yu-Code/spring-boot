package com.demo.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 项目: spring-boot
 * 时间: 2021/10/21 23:35
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String protocol = "http";
    private String host = "localhost";
    private Integer port = 8080;
    private String contextPath = "/";
    private String location = "/";
    private String url;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url == null ? String.format("%s://%s%s%s", protocol, host, port == null ? "" : ":" + port, contextPath) : url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
