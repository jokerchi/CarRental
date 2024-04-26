package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@TableName("storeup")
public class StoreUpEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public StoreUpEntity() { }

    public StoreUpEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
    private Long id;//主键id

    private Long userId;//用户id
    private Long refId;//商品id
    private String tableName;//表名
    private String name;//名称
    private String picture;//图片
    private String type;//类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)
    private String intelType;//推荐类型
    private String remark;//备注

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addTime;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRefId() { return refId; }

    public void setRefId(Long refId) { this.refId = refId; }

    public String getTableName() { return tableName; }

    public void setTableName(String tableName) { this.tableName = tableName; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getIntelType() { return intelType; }

    public void setIntelType(String intelType) { this.intelType = intelType; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }

    public Date getAddTime() { return addTime; }

    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
