package com.ms.exception;

import com.ms.entity.ResultData;
import com.ms.enums.ResultCodeEnum;
import com.ms.enums.ResultSubCodeEnum;
import lombok.Data;

/**
 * @author shiguang
 */

@Data
public class ColorfulPoetryExceptionWithRetData extends ColorfulPoetryRuntimeException{

    private ResultData  resultData;

    public ColorfulPoetryExceptionWithRetData(
            ResultCodeEnum resultCodeEnum, ResultSubCodeEnum resultSubCodeEnum ) {
        this.resultData = new ResultData<>(resultCodeEnum, resultSubCodeEnum);
    }

    public ColorfulPoetryExceptionWithRetData(
            ResultCodeEnum resultCodeEnum, String desc) {
        this.resultData = new ResultData<>(resultCodeEnum, desc);
    }

    public ColorfulPoetryExceptionWithRetData(ResultCodeEnum resultCodeEnum) {
        this.resultData = new ResultData<>(resultCodeEnum);
    }

    public <T> ColorfulPoetryExceptionWithRetData(ResultData<T> resultData) {
        this.resultData = resultData;
    }
}
