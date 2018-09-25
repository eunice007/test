package com.taikang.demo.webcast.dto.common;

/**
 * 直播券状态
 * 券状态: -1已失效|0未发放|1派券中|2待使用|3已使用
 *
 * @author Eunice
 * @date 2018/9/17
 */
public enum WebcastCardStatusEnum {
    已失效(-1, "已失效"), 未发放(0, "未发放"), 派券中(1, "派券中"), 待使用(2, "待使用"), 已使用(3, "已使用");

    private Integer code;
    private String status;

    WebcastCardStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
