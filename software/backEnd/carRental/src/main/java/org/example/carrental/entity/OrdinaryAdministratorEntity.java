package org.example.carrental.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@TableName("ordinaryAdministrator")
public class OrdinaryAdministratorEntity<T> implements Serializable { //普通管理员实体类
    private static final long serialVersionUID = 1L;

    public OrdinaryAdministratorEntity() { }
    public OrdinaryAdministratorEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @TableId
    private Long id;//主键id
    private String ordinaryAdminAccount;//普通管理员账号
    private String password;//密码
    private String ordinaryAdminName;//普通管理员姓名
    private String gender;//性别
    private String age;//年龄
    private String phone;//电话
    private String avatar;//头像

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdinaryAdminAccount() {
        return ordinaryAdminAccount;
    }

    public void setOrdinaryAdminAccount(String ordinaryAdminAccount) {
        this.ordinaryAdminAccount = ordinaryAdminAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrdinaryAdminName() {
        return ordinaryAdminName;
    }

    public void setOrdinaryAdminName(String ordinaryAdminName) {
        this.ordinaryAdminName = ordinaryAdminName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
