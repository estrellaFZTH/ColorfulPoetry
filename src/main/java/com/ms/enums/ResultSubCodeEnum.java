package com.ms.enums;

import org.apache.commons.lang.StringUtils;

/**
 * subretcode和subretdesc的枚举值
 * @author shiguang
 */

public enum ResultSubCodeEnum {

    SUCCESS_COMMON("success.common", "业务请求处理成功"),
    SUCCESS_REPEAT_REQUEST("success.repeatRequest", "重复请求返回成功"),
    AUTHERROR_USERNAME("invalid.userName", "非法的username"),
    AUTHERROR_SECRETID("invalid.secretId", "非法的secretId"),
    AUTHERROR_SIGNATURE("invalid.signature", "非法的signature"),
    AUTHERROR_TOKEN("invalid.token", "非法的token"),
    AUTHERROR_TIMESTAMP("invalid.timestamp", "非法的timestamp"),
    EXPIRED_TIMESTAMP("expired.timestamp", "timestamp过期"),
    AUTHERROR_COURSE_ID("invalid.courseId", "非法的courseId"),
    AUTHERROR_PASSWORD("invalid.password", "非法的password"),
    MISSING_PARTNERID("missing.partnerId","缺少接入方ID"),
    MISSING_SECRETID("missing.secretId","缺少签名密钥ID"),
    MISSING_TIMESTAMP("missing.timeStamp","缺少时间戳参数"),
    MISSING_NONCE("missing.nonce","缺少随机正整数参数"),
    MISSING_SIGNATUREMETHOD("missing.signatureMethod","缺少签名方法名参数"),
    MISSING_SIGN("missing.sign","缺少签名值参数"),
    INVALID_SIGN("invalid.sign","非法签名值，签名校验失败"),
    INVALID_REQUEST_METHOD("invalid.requestMethod","非POST请求"),
    INVALID_SIGNATURE_METHOD("invalid.signatureMethod","非法的签名方法"),
    SERVICEERROR_HYSTRIX("error.hystrix", "请求被熔断"),
    SERVICEERROR_PARAM_MISS("missing.param", "缺少必须业务参数"),
    SERVICEERROR_PARAM_ERROR("error.param", "非法必须业务参数"),
    SERVICE_PROBLEM_OVERLIMIT("problem.overLimit", "超过限额"),
    SERVICE_PROBLEM_INVILDSERVICEID("problem.invalidServiceId", "非法服务单号"),
    SERVICE_ADD_ORDER_REPEAT("error.repeatAddOrder","请勿重复下单"),
    INVALID_SERVICE_TYPE("invalid.serviceType","非法的服务类型"),
    INVALID_ORDER_TIME("invalid.orderTime","无效的订单时间"),
    ERROR_REQUEST_DISCARD("error.request.discard","并发重复请求"),
    ERROR_REQUEST_PARAM("error.request.param","第三方接口请求参数错误"),
    INVALID_MOBILE("invalid.mobile", "手机号非法"),
    INVALID_CODE("invalid.code", "验证码非法"),
            ;

    private String subretcode;
    private String subretdesc;

    ResultSubCodeEnum() {}

    ResultSubCodeEnum(String subretcode, String subretdesc) {
        this.subretcode = subretcode;
        this.subretdesc = subretdesc;
    }

    public String getSubretcode() {
        return subretcode;
    }

    public void setSubretcode(String subretcode) {
        this.subretcode = subretcode;
    }

    public String getSubretdesc() {
        return subretdesc;
    }

    public void setSubretdesc(String subretdesc) {
        this.subretdesc = subretdesc;
    }

    public static ResultSubCodeEnum getEnumByCode(String code){
        for(ResultSubCodeEnum subCodeEnum : ResultSubCodeEnum.values()){
            if(StringUtils.equals(code, subCodeEnum.getSubretcode())){
                return subCodeEnum;
            }
        }
        return null;
    }

}
