package com.taikang.demo.core.common.constant;

/**
 * @author Eunice
 * @date 2018/9/15
 */
public enum RedPointEnum {

    显示("1", "显示"), 不显示("0", "不显示");

    private String code;
    private String status;

    RedPointEnum(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
