package com.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@TableName("forum")
public class ForumEntity<T> implements Serializable { //租车论坛实体类
    private static final long serialVersionUID = 1L;

    public ForumEntity() { }
    public ForumEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @TableId
    private Long id;//主键

    private String title;//标题
    private String content;//内容
    private Long parentId;//父节点id
    private Long userId;//用户id
    private String userName;//用户名
    private String avatarUrl;//头像url
    private String isDone;//状态(开放/隐藏)

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addTime;

    @TableField(exist = false)
    private List<ForumEntity> childs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getParentId() { return parentId; }

    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getAvatarUrl() { return avatarUrl; }

    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getIsDone() { return isDone; }

    public void setIsDone(String isDone) { this.isDone = isDone; }

    public Date getAddTime() { return addTime; }

    public void setAddTime(Date addTime) { this.addTime = addTime; }

    public List<ForumEntity> getChilds() {
        return childs;
    }

    public void setChilds(List<ForumEntity> childs) {
        this.childs = childs;
    }
}
