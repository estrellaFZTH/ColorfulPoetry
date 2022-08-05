package com.ms.enums;


/**
 * @author shiguang
 */

public enum ResultCodeEnum {

    SUCCESS(10000, "接口调用成功"),
    PARAM_ERROR(20001, "参数不正确"),
    PARAM_ILLEGAL(20002, "参数非法"),
    PAY_NETWORK_FAILED(20006, "网络调用失败"),
    PAY_RECEIPT_FAKE(20007, "receipt data format is error"),
    INVALID_PARAMETER(20008, "参数非法"),
    PAY_CHEAT_USER(20009, "cheat user, the receipt has payed"),
    DATABASE_ERROR(20011, "数据库错误"),
    USER_NOT_LOGIN(20012, "用户未登录"),
    IMEI_IS_NULL(20013, "IMEI 为空"),
    USER_NOT_EXIST(20033, "用户不存在"),
    PROCESS_ERROR(40004, "业务处理失败"),
    ;

    private int retcode;
    private String retdesc;

    ResultCodeEnum() {}

    ResultCodeEnum(int retcode, String retdesc) {
        this.retcode = retcode;
        this.retdesc = retdesc;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getRetdesc() {
        return retdesc;
    }

    public void setRetdesc(String retdesc) {
        this.retdesc = retdesc;
    }
}