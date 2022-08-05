package com.ms.enums;

/**
 * @author shiguang
 */

public enum ToneEnum {
    // 无声调
    NONE_TONE(0, "none tone"),
    // 平声
    LEVEL_TONE(1, "level tone"),
    // 仄声
    OBLIQUE_TONE(2, "oblique tone"),
    ;

    private int type;
    private String name;

    ToneEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    ToneEnum() {}

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
