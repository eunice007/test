package com.taikang.demo.webcast.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Eunice
 * @date 2018/9/17
 */
@ApiModel(value = "直播券请求参数")
@Data
public class WebcastCouponReq {
    @ApiModelProperty(value = "直播ID", required = true, example = "1")
    private Integer webcastId;

    @ApiModelProperty(value = "泰生活用户ID", required = true, example = "1")
    private Integer appUserId;

    @ApiModelProperty(value = "代理人ID", required = true, example = "1")
    private Integer managerId;

    @ApiModelProperty(value = "渠道ID", required = true, example = "1")
    private Integer channelId;

}
