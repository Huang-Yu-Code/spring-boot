package demo.web.pojo;

import lombok.Data;

/**
 * 项目: spring-boot
 * 时间: 2021/12/16 2:43
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Captcha {
    private int width;
    private int height;
    private int length;
    private String format;
}
