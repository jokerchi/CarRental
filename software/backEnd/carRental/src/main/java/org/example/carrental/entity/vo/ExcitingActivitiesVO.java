package org.example.carrental.entity.vo;

import java.io.Serializable;

public class ExcitingActivitiesVO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String introduction;

    private String picture;

    private String content;

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
