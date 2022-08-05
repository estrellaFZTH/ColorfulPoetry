package com.ms.entity;

import com.google.common.collect.Maps;
import com.ms.enums.OperateResultEnum;
import com.ms.exception.ColorfulPoetryOperateException;
import lombok.Data;

import java.util.Map;

/**
 * 操作结果
 * @author shiguang
 */

@Data
public class OperateResult {
    // 操作结果，成功返回true，失败返回false
    private boolean operateResult;

    // 错误码
    private int errorCode;

    // 错误描述
    private String errorDesc;

    // 扩展信息
    private Map<String, Object> extend;

    public static OperateResult of(boolean optResult) {
        OperateResult operateResult = new OperateResult();
        operateResult.setOperateResult(optResult);
        return operateResult;
    }

    public static OperateResult of(OperateResultEnum operateResultEnum) {
        OperateResult operateResult = new OperateResult();
        operateResult.setErrorCode(operateResultEnum.getErrorCode());
        operateResult.setErrorDesc(operateResult.getErrorDesc());
        operateResult.setOperateResult(operateResultEnum.isOperateResult());
        return operateResult;
    }

    public OperateResult ofEnum(OperateResultEnum operateResultEnum) {
        this.setErrorCode(operateResultEnum.getErrorCode());
        this.setErrorDesc(operateResultEnum.getErrorDesc());
        return this;
    }

    public OperateResult setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public OperateResult setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
        return this;
    }

    public OperateResult addExtend(String key, Object value) {
        if (null == this.extend) {
            this.extend = Maps.newHashMap();
        }

        this.extend.put(key, value);
        return this;
    }

    public OperateResult addAllExtend(Map extendMap) {
        if (null == this.extend) {
            this.extend = Maps.newHashMap();
        }

        this.extend.putAll(extendMap);
        return this;
    }

    public OperateResult fromEnum(OperateResultEnum operateResultEnum) {
        this.setErrorCode(operateResultEnum.getErrorCode());
        this.setErrorDesc(operateResultEnum.getErrorDesc());
        return this;
    }

    public ColorfulPoetryOperateException toException() {
        return new ColorfulPoetryOperateException(this, this.errorDesc);
    }
}
