package com.feng.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章标题
     */
    @NotNull(message = "文章标题不能为空")
    private String title;
    /**
     * 文章内容
     */
    @NotNull(message = "文章内容不能为空")
    private String content;
    /**
     * 文章发布者
     */
//    @NotNull(message = "文章发布者不能为空")
    private String publisher;
    /**
     * 文章来源
     */
//    @NotNull(message = "文章来源不能为空")
    private String source;
    /**
     * 文章类型
     */
    @NotNull(message = "文章类型不能为空")
    private Integer passageTypeId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd")
    @DateTimeFormat(pattern = "yyyy年MM月dd")
    private Date publishTime;
    /**
     * 点击次数
     */
    private Integer clickNum;

    private Integer clubId;

    private Integer userId;

    public Passage() {
    }

    public Passage(@NotNull(message = "文章标题不能为空") String title, @NotNull(message = "文章内容不能为空") String content, @NotNull(message = "文章类型不能为空") Integer passageTypeId) {
        this.title = title;
        this.content = content;
        this.passageTypeId = passageTypeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPassageTypeId() {
        return passageTypeId;
    }

    public void setPassageTypeId(Integer passageTypeId) {
        this.passageTypeId = passageTypeId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
