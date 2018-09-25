package com.taikang.demo.webcast.repository.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Eunice
 * @date 2018/9/17
 */
@Entity
@Table(name = "op_webcast_record", schema = "operator", catalog = "")
public class OpWebcastRecordEntity {
    private int id;
    private String webcastCardNo;
    private Integer webcastId;
    private Integer appUserId;
    private Integer managerId;
    private Integer status;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Integer channelId;
    private Integer grantType;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "WEBCAST_CARD_NO")
    public String getWebcastCardNo() {
        return webcastCardNo;
    }

    public void setWebcastCardNo(String webcastCardNo) {
        this.webcastCardNo = webcastCardNo;
    }

    @Basic
    @Column(name = "WEBCAST_ID")
    public Integer getWebcastId() {
        return webcastId;
    }

    public void setWebcastId(Integer webcastId) {
        this.webcastId = webcastId;
    }

    @Basic
    @Column(name = "APP_USER_ID")
    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    @Basic
    @Column(name = "MANAGER_ID")
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "MODIFY_TIME")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "CHANNEL_ID")
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "GRANT_TYPE")
    public Integer getGrantType() {
        return grantType;
    }

    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }
}
