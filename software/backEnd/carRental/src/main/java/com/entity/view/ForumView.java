package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import com.entity.ForumEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ForumView(){
    }

    public ForumView(ForumEntity forumEntity){
        try {
            BeanUtils.copyProperties(this, forumEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
