package com.ms.util;

import com.google.common.collect.Maps;
import com.ms.entity.ToneTypeAndPart;
import com.ms.enums.DocEnum;
import com.ms.enums.PhonologyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.io.File;
import java.util.HashMap;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Dict Init ...");

        File file = new File("doc");
        if (!file.exists()) {
            log.error(file + "is not found.");
            return;
        }

        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isFile()) {
                if (f.getName().equals(DocEnum.PING_SHUI_YUN.getName())) {
                    PhonologyMap.put(PhonologyEnum.PING_SHUI_YUN.getName(), DataProcessor.processor("doc/" + f.getName()));
                } else if (f.getName().equals(DocEnum.ZHONG_HUA_ZHENG_YUN.getName())) {
                    PhonologyMap.put(PhonologyEnum.ZHONG_HUA_ZHENG_YUN.getName(), DataProcessor.processor("doc/" + f.getName()));
                } else if (f.getName().equals(DocEnum.CI_LIN_ZHENG_YUN.getName())) {
                    PhonologyMap.put(PhonologyEnum.CI_LIN_ZHENG_YUN.getName(), DataProcessor.processor("doc/" + f.getName()));
                }

            } else {
                log.error(f + "is not a dir.");
            }
        }
    }
}
