package com.ms.entity;

import lombok.Data;

/**
 * @author shiguang
 */
@Data
public class ToneTypeAndPart {

    // 声调 1-平声， 2-仄声
    private String toneType;
    // 声部
    private String part;

}
