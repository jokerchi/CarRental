package com.entity;



import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("token")
public class TokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;//主键id

    private Long userId;//用户id
    private String userName;//用户名
    private String tableName;//表名
    private String role;//角色
    private String token;//token
    private Date expiratedTime;//过期时间
    private Date addTime;//新增时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getTableName() { return tableName; }

    public void setTableName(String tableName) { this.tableName = tableName; }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiratedTime() { return expiratedTime; }

    public void setExpiratedTime(Date expiratedTime) { this.expiratedTime = expiratedTime; }

    public Date getAddTime() { return addTime; }

    public void setAddTime(Date addTime) { this.addTime = addTime; }

    public TokenEntity(Long userId, String userName, String tableName, String role, String token, Date expiratedTime) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.tableName = tableName;
        this.role = role;
        this.token = token;
        this.expiratedTime = expiratedTime;
    }

    public TokenEntity() { }
}
