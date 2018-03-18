package util;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Properties;

public class FileUploadUtil {

    public static void upload(String fileName, @RequestParam(value = "file")MultipartFile file) throws IOException {
        File newFile = new File(getUploadBasePath(), file.getOriginalFilename());
        file.transferTo(newFile);
    }

    private static String getUploadBasePath() {
        Properties properties = new Properties();
        try {
            InputStreamReader in = new InputStreamReader(
                    FileUploadUtil.class.getClassLoader().getResourceAsStream("fileupload.properties"), "UTF-8");
            properties.load(in);
            // 获取value
            return properties.getProperty("baseUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
