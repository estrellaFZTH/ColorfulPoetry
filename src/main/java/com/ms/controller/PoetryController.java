package com.ms.controller;


import com.ms.entity.ResultBuilder;
import com.ms.entity.ResultData;
import com.ms.entity.ToneTypeAndPart;
import com.ms.enums.PhonologyEnum;
import com.ms.enums.ResultCodeEnum;
import com.ms.exception.ColorfulPoetryExceptionWithRetData;
import com.ms.model.request.PoteryRequest;
import com.ms.model.response.PoteryResponse;
import com.ms.model.response.PoteryResponse.Word;
import com.ms.util.ChineseAndEnglishUtils;
import com.ms.util.DictCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shiguang
 */

@Slf4j
@RestController
@RequestMapping("/")
public class PoetryController {


    @CrossOrigin
    @PostMapping("/poetry")
    public ResultData<PoteryResponse> Poetry(@RequestBody PoteryRequest poteryRequest){
        PoteryResponse poteryResponse = new PoteryResponse();
        poteryResponse.setTitle(poteryRequest.getTitle());
        poteryResponse.setAuthor(poteryRequest.getAuthor());
        if (poteryRequest.getType() == null) {
//            return new ColorfulPoetryExceptionWithRetData(ResultCodeEnum.PARAM_ERROR, "韵表选择不能为空");
            return ResultBuilder.buildErrorResultByEnum(ResultCodeEnum.PARAM_ERROR, "韵表选择不能为空");
        }
        String dictName = "";
        if (PhonologyEnum.PING_SHUI_YUN.getType() == poteryRequest.getType()) {
            dictName = PhonologyEnum.PING_SHUI_YUN.getName();
        } else if (PhonologyEnum.CI_LIN_ZHENG_YUN.getType() == poteryRequest.getType()) {
            dictName = PhonologyEnum.CI_LIN_ZHENG_YUN.getName();
        } else if (PhonologyEnum.ZHONG_HUA_ZHENG_YUN.getType() == poteryRequest.getType()) {
            dictName = PhonologyEnum.ZHONG_HUA_ZHENG_YUN.getName();
        }
        Map<String, List<ToneTypeAndPart>> dictMap = DictCache.PhonologyMap.get(dictName);
        List<List<Word>> resContent = new ArrayList<>();
        List<String> contentList = poteryRequest.getContent();
        if(contentList.size() == 0) {
//            throw new ColorfulPoetryExceptionWithRetData(ResultCodeEnum.PARAM_ERROR, "诗歌正文不能为空");
            return ResultBuilder.buildErrorResultByEnum(ResultCodeEnum.PARAM_ERROR, "诗歌正文不能为空");
        }
        for (String str : contentList) {
            List<Word> wordList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if (ChineseAndEnglishUtils.isChinesePunctuation(str.charAt(i))) {
                    wordList.add(new Word(s));
                } else {
                    Word word = new Word();
                    word.setText(s);
                    if (dictMap.get(s) == null) {
                        log.error(s + ":" + dictMap.get(s));
                        return ResultBuilder.buildErrorResultByEnum(ResultCodeEnum.PROCESS_ERROR, "系统内部错误，请联系管理员");
                    }
                    word.setToneTypeAndPart(dictMap.get(s));
                    wordList.add(word);
                }
            }
            resContent.add(wordList);
        }
        poteryResponse.setContent(resContent);

        return ResultBuilder.buildSuccessResult(poteryResponse);

    }

}
