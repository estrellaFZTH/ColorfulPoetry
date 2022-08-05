package com.ms.enums;

/**
 * @author shiguang
 */

public enum PhonologyEnum {
    PING_SHUI_YUN(1, "ping shui yun"),
    CI_LIN_ZHENG_YUN(2, "ci lin zheng yun"),
    ZHONG_HUA_ZHENG_YUN(3, "zhong hua zheng yun"),
    ;

    private int type;
    private String name;

    PhonologyEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    PhonologyEnum() {}

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
