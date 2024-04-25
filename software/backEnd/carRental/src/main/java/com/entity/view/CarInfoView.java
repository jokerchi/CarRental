package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.CarInfoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("carinfo")
public class CarInfoView  extends CarInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CarInfoView(){
    }

    public CarInfoView(CarInfoEntity carInfoEntity){
        try {
            BeanUtils.copyProperties(this, carInfoEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
