package com.taikang.demo.coupon.repository.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@Entity
@DynamicUpdate
@Table(name = "coupon_info")
@Data
public class CouponInfoEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键ID", required = true, example = "")
    private Integer id;

    @Column(name = "COUPON_BATCH_CODE")
    @ApiModelProperty(value = "批次号", required = true, example = "123123")
    private String couponBatchCode;

    @Column(name = "COUPON_NAME")
    @ApiModelProperty(value = "券的名称", required = true, example = "test")
    private String couponName;

    @Column(name = "COUPON_TYPE")
    @ApiModelProperty(value = "券类型", required = true, example = "白金-常规套餐")
    private String couponType;

    @Column(name = "COUPON_PRODUCT_NO")
    @ApiModelProperty(value = "关联产品的编号", required = true, example = "CP001")
    private String couponProductNo;

    @Column(name = "COUPON_PRICE")
    @ApiModelProperty(value = "门市价", required = true, example = "300")
    private String couponPrice;

    @Column(name = "COUPON_DENOMINATION")
    @ApiModelProperty(value = "券的优惠面额", required = true, example = "200")
    private String coupondenomination;

    @Column(name = "COUPON_NUM")
    @ApiModelProperty(value = "券的数量", required = true, example = "100")
    private Integer couponNum;

    @Column(name = "COUPON_ENABLE_TIME")
    @ApiModelProperty(value = "券生效时间", required = true, example = "2018-08-09 00:00:00")
    private Date couponEnableTime;

    @Column(name = "COUPON_DISABLE_TIME")
    @ApiModelProperty(value = "券失效时间", required = true, example = "2018-08-09 00:00:00")
    private Date couponDisableTime;

    @Column(name = "COUPON_STATUS_ID")
    @ApiModelProperty(value = "券状态", required = true, example = "0")
    private Integer couponStatusId;

    @Column(name = "CHANNEL_ID")
    @ApiModelProperty(value = "渠道ID", required = true, example = "2")
    private Integer channelId;

    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "机构名称", required = true, example = "燕园")
    private String orgName;

    @Column(name = "ORG_NO")
    @ApiModelProperty(value = "机构编号", required = true, example = "1")
    private String orgNo;

    @Column(name = "OPERATOR")
    @ApiModelProperty(value = "操作人", required = true, example = "zs")
    private String operator;

    @Column(name = "EXPAND")
    @ApiModelProperty(value = "扩展字段", required = true, example = "")
    private String expand;

    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true, example = "2018-08-09 00:00:00")
    private Date createTime;

    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间", required = true, example = "2018-08-09 00:00:00")
    private Date modifyTime;

    @Column(name = "COUPON_NO")
    @ApiModelProperty(value = "券编号", required = true, example = "123123")
    private String couponNo;

    @Column(name = "IMG_URL")
    @ApiModelProperty(value = "图片URL", required = true, example = "")
    private String imgUrl;

    @Column(name = "ORG_PHONE")
    @ApiModelProperty(value = "机构电话", required = true, example = "13439300560")
    private String orgPhone;

    @Column(name = "OP_PRODUCT_NAME")
    @ApiModelProperty(value = "关联产品的名称", required = true, example = "test")
    private String opProductName;

    @Column(name = "COUPON_VALIDITY")
    @ApiModelProperty(value = "有效期(获得券后的有效期)", required = true, example = "10")
    private Integer couponValidity;

    @Column(name = "RULES")
    @ApiModelProperty(value = "使用规则", required = true, example = "具体使用规则")
    private String rules;

    @Column(name = "COUPON_LIMIT")
    @ApiModelProperty(value = "每人每天限领数目", required = true, example = "5")
    private Integer couponLimit;

    @Column(name = "UPLOAD_METHOD")
    @ApiModelProperty(value = "上传方式", required = true, example = "1")
    private Integer uploadMethod;

    @Column(name = "PUBLISH_TYPE")
    @ApiModelProperty(value = "1机构发券|2自助发券", required = true, example = "1")
    private Integer publishType;

}
