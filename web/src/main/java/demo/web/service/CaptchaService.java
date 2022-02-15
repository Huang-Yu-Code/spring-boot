package demo.web.service;

import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:36
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@Service
public class CaptchaService {

    private final Producer producer;

    public CaptchaService(Producer producer) {
        this.producer = producer;
    }

    public byte[] get(){
        String text = producer.createText();
        BufferedImage bufferedImage = producer.createImage(text);
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage,"jpeg",byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
