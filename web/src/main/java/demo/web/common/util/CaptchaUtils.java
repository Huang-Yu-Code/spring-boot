package demo.web.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 * 验证码工具类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class CaptchaUtils {

    private CaptchaUtils(){}

    /**
     * 纯数字
     */
    private static final char[] NUMBER = "0123456789".toCharArray();
    /**
     * 数字&字母
     */
    private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    /**
     * 随机颜色
     *
     * @return Color
     */
    private static Color color() {
        Random random = new SecureRandom();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /**
     * 生成验证码
     *
     * @param number true:数字,false:数字+字母
     * @param length 长度
     * @return 验证码字符串
     */
    public static String getText(boolean number, int length) {
        char[] chars = number ? NUMBER : CHARS;
        length = Math.max(length, 4);
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(chars[new SecureRandom().nextInt(chars.length)]);
        }
        return text.toString();
    }

    /**
     * 生成验证码图像
     *
     * @param width  宽度
     * @param height 高度
     * @param format 格式
     * @param text   字符串
     * @return base64编码
     */
    public static String getImage(int width, int height, String format, String text) {
        if (width <= 0 || height <= 0 || format == null || text == null || text.length() <= 0) {
            throw new IllegalArgumentException("验证码属性参数异常");
        }
        int length = text.length();
        char[] chars = text.toCharArray();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(color());
        graphics.fillRect(0, 0, width, height);
        graphics.setFont(new Font(null, Font.BOLD, height));
        for (int i = 0; i < length; i++) {
            graphics.setColor(color());
            graphics.drawString(chars[i] + "", i * (width / length), height - 10);
        }
        try {
            byte[] bytes;
            ImageIO.write(image, format, outputStream);
            bytes = outputStream.toByteArray();
            return String.format("data:image/%s;base64,%s", format, Base64.getEncoder().encodeToString(bytes));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("生成验证码图片失败");
        }
    }
}
