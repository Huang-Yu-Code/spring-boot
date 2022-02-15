package demo.web.common.util;

import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 * 文件工具类
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
public class FileUtils {

    private FileUtils(){
    }

    private static final String REGEX = "\\.";
    private static final String SYMBOL = ".";

    public static String getFormat(String filename) {
        String[] strings = filename.split(REGEX);
        int length = strings.length;
        return strings[length - 1];
    }

    public static String rename(String filename) {
        String format = getFormat(filename);
        return UUID.randomUUID() + SYMBOL + format;
    }

    public static String save(MultipartFile multipartFile, String path) {
        try {
            String filename = multipartFile.getOriginalFilename();
            filename = rename(filename);
            String url = path + filename;
            File file = new File(url);
            if (!file.exists()) {
                boolean result = file.mkdirs();
                Assert.isTrue(result, "文件夹创建失败");
            }
            multipartFile.transferTo(file);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> save(MultipartFile[] multipartFiles, String path) {
        List<String> strings = new ArrayList<>(multipartFiles.length);
        for (MultipartFile multipartFile : multipartFiles) {
            String filename = save(multipartFile, path);
            strings.add(filename);
        }
        return strings;
    }

}
