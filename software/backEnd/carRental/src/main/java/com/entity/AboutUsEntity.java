package com.entity;



import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@TableName("aboutus")
public class AboutUsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;//控制序列化版本的兼容性

    public AboutUsEntity() { }

    public AboutUsEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
    private Long id;//主键id

    private String title;//标题
    private String subtitle;//副标题
    private String content;//内容
    private String picture1;//图片1url
    private String picture2;//图片2url
    private String picture3;//图片3url
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addTime;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture1() { return picture1; }

    public void setPicture1(String picture1) { this.picture1 = picture1; }

    public String getPicture2() { return picture2; }

    public void setPicture2(String picture2) { this.picture2 = picture2; }

    public String getPicture3() { return picture3; }

    public void setPicture3(String picture3) { this.picture3 = picture3; }

    public Date getAddTime() { return addTime; }

    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
