# Spring-Boot-Mail

## maven

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

## properties

```properties
spring.mail.protocol=smtp
spring.mail.host=smtp.qq.com
spring.mail.port=587
spring.mail.username=coderfast@qq.com
spring.mail.password=xxx
```

## service

```java
public interface MailService {
    /**
     * 发送邮箱
     *
     * @param email   邮箱
     * @param subject 主题
     * @param text    内容
     */
    void sendText(String email, String subject, String text);

    /**
     * 发送邮箱
     *
     * @param email   邮箱
     * @param subject 主题
     * @param html    内容
     * @param files   内联附件
     */
    void sendHtml(String email, String subject, String html, Map<String, File> files);

    /**
     * 发送邮箱
     *
     * @param email   邮箱
     * @param subject 主题
     * @param text    内容
     * @param files    附件
     */
    void sendFile(String email, String subject, String text, Map<String, File> files);
```

```java
@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private final MailProperties mailProperties;

    private final MimeMessage mimeMessage;

    public MailServiceImpl(JavaMailSender mailSender, MailProperties mailProperties) {
        this.mailSender = mailSender;
        this.mailProperties = mailProperties;
        this.mimeMessage = this.mailSender.createMimeMessage();
    }

    @Override
    public void sendText(String email, String subject, String text) {
        MimeMessageHelper helper = new MimeMessageHelper(this.mimeMessage);
        try {
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(this.mimeMessage);
    }

    @Override
    public void sendHtml(String email, String subject, String html, Map<String, File> files) {
        try {
            MimeMessageHelper helper = new MimeMessageHelper(this.mimeMessage, true);
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(String.format(html, files.keySet().toArray()), true);
            for (String filename : files.keySet()) {
                helper.addInline(filename, files.get(filename));
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(this.mimeMessage);
    }

    @Override
    public void sendFile(String email, String subject, String text, Map<String, File> files) {
        try {
            MimeMessageHelper helper = new MimeMessageHelper(this.mimeMessage, true);
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text);
            for (String filename : files.keySet()) {
                helper.addAttachment(filename, files.get(filename));
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(this.mimeMessage);
    }
}
```

## test

```java
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    String email = "13713507941@163.com";
    String subject = "测试主题";
    String text = "测试正文";
    String html = "<html><body><a href='https://spring.io/'>百度一下</a><img src='cid:%s'></body></html>";
    String file = "file/mail.png";

    @Test
    void sendText() {
        mailService.sendText(email, subject, text);
    }

    @Test
    void sendHtml() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(this.file);
        File file = classPathResource.getFile();
        HashMap<String, File> files = new HashMap<>();
        files.put(this.file, file);
        mailService.sendHtml(email, subject, html, files);
    }

    @Test
    void sendFile() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(this.file);
        File file = classPathResource.getFile();
        HashMap<String, File> files = new HashMap<>();
        files.put(this.file, file);
        mailService.sendFile(email, subject, text, files);
    }
}
```