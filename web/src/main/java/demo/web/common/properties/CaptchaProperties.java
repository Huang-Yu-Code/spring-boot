package demo.web.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:07
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {
    private int width;
    private int height;
    private String format;
    private int length;
    private boolean number;

    public CaptchaProperties() {
        this.width = 200;
        this.height = 50;
        this.format = "jpeg";
        this.length = 4;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }
}
