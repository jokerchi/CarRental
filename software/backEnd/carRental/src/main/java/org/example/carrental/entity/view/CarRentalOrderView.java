package org.example.carrental.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.CarRentalOrderEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("carrentalorder")
public class CarRentalOrderView extends CarRentalOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CarRentalOrderView(){ }

    public CarRentalOrderView(CarRentalOrderEntity carRentalOrderEntity){
        try {
            BeanUtils.copyProperties(this, carRentalOrderEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
