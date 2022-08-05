package com.ms.enums;

/**
 * @author shiguang
 */
public enum DocEnum {

    PING_SHUI_YUN(1, "PingShuiYun.txt"),
    CI_LIN_ZHENG_YUN(2, "CiLinZhengYun.txt"),
    ZHONG_HUA_ZHENG_YUN(3, "ZhongHuaZhengYun.txt"),
    ;

    private int type;
    private String name;

    DocEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    DocEnum() {}

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
