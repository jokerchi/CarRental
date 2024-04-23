package org.example.carrental.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.StoreUpEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("storeup")
public class StoreUpView extends StoreUpEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public StoreUpView(){ }

    public StoreUpView(StoreUpEntity storeupEntity){
        try {
            BeanUtils.copyProperties(this, storeupEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
