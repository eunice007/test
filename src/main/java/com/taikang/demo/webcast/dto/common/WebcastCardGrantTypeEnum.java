package com.taikang.demo.webcast.dto.common;

/**
 * 观影券发放类型
 * 发放类型: 0系统自动发放|1用户索券代理人同意发放|2代理人定向发放
 *
 * @author Eunice
 * @date 2018/9/17
 */
public enum WebcastCardGrantTypeEnum {
    系统自动发放(0, "系统自动发放"), 用户索券(1, "用户索券"), 代理人定向发放(2, "代理人定向发放");

    private Integer code;
    private String grantType;

    WebcastCardGrantTypeEnum(Integer code, String grantType) {
        this.code = code;
        this.grantType = grantType;
    }

    public Integer getCode() {
        return code;
    }

    public String getGrantType() {
        return grantType;
    }
}
