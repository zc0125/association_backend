package com.feng.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 */
@Data
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 活动名称
     */
    @NotNull(message = "活动名称不能为空")
    private String activityName;
    /**
     * 活动地点
     */
    @NotNull(message = "活动地点不能为空")
    private String site;
    /**
     * 活动举行时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd")
    @DateTimeFormat(pattern = "yyyy年MM月dd")
    private String holdTime;
    /**
     * 活动介绍
     */
    @NotNull(message = "活动简介不能为空")
    private String introduce;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd")
    @DateTimeFormat(pattern = "yyyy年MM月dd")
    private Date applyTime;

    private Integer userId;
    /**
     * 社团联是否批准
     */
    private Integer permission;
    @NotNull(message = "活动类型不能为空")
    private Integer activityTypeId;
    private Integer clubId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(String holdTime) {
        this.holdTime = holdTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }
}