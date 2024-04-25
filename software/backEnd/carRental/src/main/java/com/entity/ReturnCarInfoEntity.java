package com.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@TableName("returncarinfo")
public class ReturnCarInfoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public ReturnCarInfoEntity() { }
    public ReturnCarInfoEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
    private Long id;

    private String orderNumber;//订单编号
    private String carNumber;//车牌号
    private String carBrand;//车辆品牌

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @DateTimeFormat
    private Date returnDate;//还车日期
    private String returnRemarks;//还车备注
    private String clientAccount;//用户账号
    private String clientName;//用户姓名
    private String phone;//电话
    private String idCard;//身份证号
    private String adminAccount;//普通管理员账号
    private String adminName;//普通管理员姓名
    private Long crossUserId;//跨表用户id-对应用户id
    private Long crossRefId;//跨表主键id-对应租车订单id
    private String isReviewed;//是否审核
    private String reviewReply;//审核回复

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnRemarks() {
        return returnRemarks;
    }

    public void setReturnRemarks(String returnRemarks) {
        this.returnRemarks = returnRemarks;
    }

    public String getClientAccount() { return clientAccount; }

    public void setClientAccount(String clientAccount) { this.clientAccount = clientAccount; }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Long getCrossUserId() {
        return crossUserId;
    }

    public void setCrossUserId(Long crossUserId) {
        this.crossUserId = crossUserId;
    }

    public Long getCrossRefId() {
        return crossRefId;
    }

    public void setCrossRefId(Long crossRefId) {
        this.crossRefId = crossRefId;
    }

    public String getIsReviewed() { return isReviewed; }

    public void setIsReviewed(String isReviewed) { this.isReviewed = isReviewed; }

    public String getReviewReply() {
        return reviewReply;
    }

    public void setReviewReply(String reviewReply) {
        this.reviewReply = reviewReply;
    }

    public Date getAddTime() { return addTime; }

    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
