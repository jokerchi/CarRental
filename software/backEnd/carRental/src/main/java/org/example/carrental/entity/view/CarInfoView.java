package org.example.carrental.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.CarInfoEntity;

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
