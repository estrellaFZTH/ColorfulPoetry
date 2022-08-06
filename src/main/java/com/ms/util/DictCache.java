package com.ms.util;

import com.google.common.collect.Maps;
import com.ms.entity.ToneTypeAndPart;
import com.ms.enums.DocEnum;
import com.ms.enums.PhonologyEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author shiguang
 */

@Slf4j
@Component
@Order(2)
public class DictCache implements ApplicationRunner {

    public static Map<String, Map<String, List<ToneTypeAndPart>>> PhonologyMap =  Maps.newHashMap();

//    private final static String docSource = "src/main/resources/lib/doc";
    private final static String docSource = "/ms/doc";  // 服务器文件存储路径



    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Dict Init ...");
        // 本地运行
//        File file = new File(docSource);

        // jar 包运行
//        InputStream in = DictCache.class.getResourceAsStream("/doc");
//        String tempPath = FileUtils.getTempDirectory().getPath();
//        File file = new File(tempPath);
//        FileUtils.copyInputStreamToFile(in, file);
        File file = new File("/ms/doc");  // 服务器文件存储路径

        if (!file.exists()) {
            log.error(file + " is not found.");
            return;
        }

        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isFile()) {
                if (f.getName().equals(DocEnum.PING_SHUI_YUN.getName())) {
                    PhonologyMap.put(PhonologyEnum.PING_SHUI_YUN.getName(), DataProcessor.processor(docSource + File.separator + f.getName()));
                } else if (f.getName().equals(DocEnum.ZHONG_HUA_ZHENG_YUN.getName())) {
                    PhonologyMap.put(PhonologyEnum.ZHONG_HUA_ZHENG_YUN.getName(), DataProcessor.processor(docSource + File.separator  + f.getName()));
                } else if (f.getName().equals(DocEnum.CI_LIN_ZHENG_YUN.getName())) {
                    PhonologyMap.put(PhonologyEnum.CI_LIN_ZHENG_YUN.getName(), DataProcessor.processor(docSource + File.separator  + f.getName()));
                }

            } else {
                log.error(f + "is not a dir.");
            }
        }
    }
}
