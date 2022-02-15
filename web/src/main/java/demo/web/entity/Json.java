package demo.web.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 项目: spring-boot
 * 时间: 2021/12/23 3:00
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Data
public class Json {
    private String id;
    @NotNull(message = "姓名不能为空")
    @Length(min = 1, max = 16,message = "姓名长度在1-16")
    private String name;
    @Min(value = 0, message = "年纪不能小于0")
    @Max(value = 200, message = "年纪不能大于200")
    private Integer age;
}
