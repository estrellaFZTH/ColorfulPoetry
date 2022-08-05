package com.ms.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author shiguang
 */

@Data
public class PoteryRequest {

    // 音韵偏好  0-平水韵，1-词林正韵，2-中华正韵
    private Integer type;
    // 诗歌名字
    private String title;
    // 诗歌作者
    private String author;
    // 诗歌正文
    private List<String> content;

}
