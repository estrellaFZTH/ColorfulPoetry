package com.ms.model.response;

import com.ms.entity.ToneTypeAndPart;
import lombok.Data;

import java.util.List;

/**
 * @author shiguang
 */

@Data
public class PoteryResponse {

    // 诗歌名字
    private String title;
    // 诗歌作者
    private String author;
    // 诗歌正文
    private List<List<Word>> content;

    @Data
    public static class Word {
        private String text;
        private List<ToneTypeAndPart> toneTypeAndPart;

        public Word() {}
        public Word(String text) {
            this.text = text;
        }
    }

}
