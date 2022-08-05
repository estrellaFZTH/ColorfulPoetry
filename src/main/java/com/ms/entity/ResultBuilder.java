package com.ms.entity;

import com.ms.enums.ResultCodeEnum;

/**
 * @author shiguang
 */

public class ResultBuilder {

    public static ResultData buildByEnum(ResultCodeEnum retResultEnum, Object data) {
        ResultData retResult = new ResultData<>();
        retResult.setRetcode(retResultEnum.getRetcode());
        retResult.setRetdesc(retResultEnum.getRetdesc());
        retResult.setData(data);
        return retResult;
    }

    public static <T> ResultData<T> buildSuccessResult(T data) {
        ResultData<T> retResult = new ResultData<T>();
        retResult.setRetcode(ResultCodeEnum.SUCCESS.getRetcode());
        retResult.setRetdesc(ResultCodeEnum.SUCCESS.getRetdesc());
        retResult.setData(data);
        return retResult;
    }

    public static <T> ResultData<T> buildErrorResultByEnum(ResultCodeEnum retResultEnum, String desc) {
        ResultData<T> retResult = new ResultData<>();
        retResult.setRetcode(retResultEnum.getRetcode());
        retResult.setRetdesc(desc);
        retResult.setData(null);
        return retResult;
    }

    public static ResultData<Object> buildErrorResultByEnum(
            ResultCodeEnum retResultEnum, String desc, Object data) {
        ResultData<Object> retResult = new ResultData<>();
        retResult.setRetcode(retResultEnum.getRetcode());
        retResult.setRetdesc(desc);
        retResult.setData(data);
        return retResult;
    }

    public static ResultData<Object> buildErrorResultAsUnknownException(
            Exception ex, boolean withExceptionData) {
        Object obj = withExceptionData ? ex : null;
        return buildErrorResultByEnum(
                ResultCodeEnum.PROCESS_ERROR,
                String.format(
                        "接口异常: exceptionName = %s and exceptionMsg = %s",
                        ex.getClass().getSimpleName(), ex.getMessage()),
                obj);
    }

    public static ResultData buildErrorResultByEnum(Object obj) {
        ResultData retResult = new ResultData();
        if (obj instanceof ResultData) {
            ResultData resultData = (ResultData) obj;
            retResult.setRetcode(resultData.getRetcode());
            retResult.setRetdesc(resultData.getRetdesc());
        }
        return retResult;
    }

}
