package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@TableName("cancelOrderEntity")
public class CancelOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public CancelOrderEntity() {

    }

    public CancelOrderEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
    private Long id;

    private String orderNumber;
    private String carNumber;
    private String carBrand;
    private Float price;
    private Integer leaseTerm;
    private Float totalPrice;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @DateTimeFormat
    private Date cancelDate;

    private String cancelReason;
    private String clientAccount;
    private String clientName;
    private String phone;
    private String idCard;
    private String administratorAccount;
    private String administratorName;
    private Long crossUserId;
    private Long crossRefId;
    private String isReviewed;
    private String reviewReply;
    private String ispay;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
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

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
