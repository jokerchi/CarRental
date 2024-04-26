package com.entity.vo;

import java.io.Serializable;

public class AboutUsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String subtitle;

    private String content;

    private String picture1;

    private String picture2;

    private String picture3;

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }


    public String getPicture2() {
        return picture2;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public String getPicture3() {
        return picture3;
    }


}
