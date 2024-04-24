package org.example.carrental.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.AboutUsEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("aboutus")
public class AboutUsView extends AboutUsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public AboutUsView(){
    }

    public AboutUsView(AboutUsEntity aboutUsEntity){
        try {
            BeanUtils.copyProperties(this, aboutUsEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
