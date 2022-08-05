package com.ms.exception;

import com.ms.entity.OperateResult;
import lombok.Data;

import java.util.Map;

/**
 * @author shiguang
 */

public class ColorfulPoetryOperateException extends ColorfulPoetryRuntimeException{

    private OperateResult operateResult;

    public ColorfulPoetryOperateException(OperateResult operateResult) {
        this.operateResult = operateResult;
    }

    public ColorfulPoetryOperateException(OperateResult operateResult, String message) {
        super(message);
        this.operateResult = operateResult;
    }

    public OperateResult getOperateResult() {
        return operateResult;
    }

}
