package com.ms.entity;

import com.ms.enums.ResultCodeEnum;
import com.ms.enums.ResultSubCodeEnum;

import java.io.Serializable;

/**
 * @author shiguang
 */

public class ResultData<T> extends ResultInfo implements Serializable {

    private static final long serialVersionUID = -4444641144802156949L;
    private Object data = null;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultData() {}

    public ResultData(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getRetcode(), resultCodeEnum.getRetdesc());
    }

    public ResultData(ResultCodeEnum resultCodeEnum, T data) {
        super(resultCodeEnum.getRetcode(), resultCodeEnum.getRetdesc());
        this.data = data;
    }

    public ResultData(ResultCodeEnum resultCodeEnum, String desc) {
        super(resultCodeEnum.getRetcode(), desc);
    }

    public ResultData(ResultCodeEnum resultCodeEnum, ResultSubCodeEnum resultSubCodeEnum) {
        super(
                resultCodeEnum.getRetcode(),
                resultCodeEnum.getRetdesc(),
                resultSubCodeEnum.getSubretcode(),
                resultSubCodeEnum.getSubretdesc());
    }

    public ResultData(ResultCodeEnum resultCodeEnum, ResultSubCodeEnum resultSubCodeEnum, T data) {
        this(resultCodeEnum, resultSubCodeEnum);
        this.data = data;
    }

}
