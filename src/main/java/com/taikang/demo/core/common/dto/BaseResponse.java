package com.taikang.demo.core.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@ApiModel
public class BaseResponse<T> {
    @ApiModelProperty(value = "状态码, 0成功|-1token过期|-2参数错误|-3其他已知错误|-4其他未知错误", example = "-2", required = true)
    private int code = -4;

    @ApiModelProperty(value = "结果描述", example = "参数错误")
    private String msg = "未知错误";

    @ApiModelProperty(value = "详细数据")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(T data) {
        this.code = 0;
        this.msg = "SUCCESS";
        this.data = data;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseResponse{");
        sb.append("code=").append(code);
        sb.append(", msg='").append(msg).append("'");
        sb.append(", data=").append(data);
        sb.append("}");
        return sb.toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
