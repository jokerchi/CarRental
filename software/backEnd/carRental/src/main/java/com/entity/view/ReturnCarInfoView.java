package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ReturnCarInfoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("returncarinfo")
public class ReturnCarInfoView extends ReturnCarInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ReturnCarInfoView(){
    }

    public ReturnCarInfoView(ReturnCarInfoEntity returnCarInfoEntity){
        try {
            BeanUtils.copyProperties(this, returnCarInfoEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
