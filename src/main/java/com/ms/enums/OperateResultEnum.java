package com.ms.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ms.entity.OperateResult;
import com.ms.exception.ColorfulPoetryOperateException;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.util.Strings;

/**
 * ENUM 对象序列化
 * @author shiguang
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OperateResultEnum {

    OPERATE_SUCCESS(10000, null, true),
    // 通用操作异常
    OPERATE_FAIL_RETRY(10001, "操作失败，请重试", false),
    ILLEGAL_DATA_ERROR(10002, "数据配置异常",false),
    ILLEGAL_ARGUMENT_ERROR(10003, "请求参数异常",false),
    ILLEGAL_PROCESS_ERROR(10004, "数据处理异常",false),
    ;

    private int errorCode;
    private String errorDesc;
    private boolean operateResult;

    OperateResultEnum(int errorCode, String errorDesc, boolean operateResult) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.operateResult = operateResult;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public boolean isOperateResult() {
        return operateResult;
    }

    public OperateResult toOperateResult() {
        return toOperateResult(Strings.EMPTY);
    }

    public OperateResult toOperateResult(String errorDesc) {
        OperateResult operateResult = new OperateResult();
        operateResult.setErrorCode(this.errorCode);
        operateResult.setErrorDesc(StringUtils.isNotEmpty(errorDesc) ? errorDesc : this.errorDesc);
        operateResult.setOperateResult(this.operateResult);
        return operateResult;
    }

    public ColorfulPoetryOperateException toException() {
        return toOperateResult().toException();
    }
    public OperateResult toOperateResult(OperateResult operateResult) {
        if (null == operateResult) {
            return toOperateResult();
        }

        operateResult.setErrorCode(errorCode);
        operateResult.setErrorDesc(errorDesc);
        operateResult.setOperateResult(this.operateResult);
        return operateResult;
    }

}
