package com.entity.view;

import com.entity.CancelOrderEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class CancelOrderView extends CancelOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CancelOrderView(){ }

    public CancelOrderView(CancelOrderEntity cancelOrderEntity){
        try {
            BeanUtils.copyProperties(this, cancelOrderEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
