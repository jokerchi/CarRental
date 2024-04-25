package com.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@TableName("carrentalorder")
public class CarRentalOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public CarRentalOrderEntity() { }

    public CarRentalOrderEntity(T t) {
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
    private String carBrand;//车品牌
    private Float dailyPrice;//租价
    private Integer leaseTerm;//租期
    private Float totalPrice;//总价

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @DateTimeFormat
    private Date startDate;

    private String remark;//备注
    private String clientAccount;//用户账号
    private String clientName;//用户姓名
    private String phone;//电话
    private String idCard;//身份证
    private String administratorAccount;//普通管理员账号
    private String administratorName;//普通管理员姓名
    private String isReviewed;//是否审核
    private String reviewReply;//审核回复
    private String isPay;//是否支付
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

    public Float getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(Float dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public Integer getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(Integer leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public String getClientName() {
        return clientName;
    }

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

    public String getAdministratorAccount() {
        return administratorAccount;
    }

    public void setAdministratorAccount(String administratorAccount) {
        this.administratorAccount = administratorAccount;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(String isReviewed) {
        this.isReviewed = isReviewed;
    }

    public String getReviewReply() {
        return reviewReply;
    }

    public void setReviewReply(String reviewReply) {
        this.reviewReply = reviewReply;
    }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }

    public String getIsPay() { return isPay; }

    public void setIsPay(String isPay) { this.isPay = isPay; }

    public Date getAddTime() { return addTime; }

    public void setAddTime(Date addTime) { this.addTime = addTime; }
}
