package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.OrdinaryAdministratorEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("ordinaryadministrator")
public class OrdinaryAdministratorView extends OrdinaryAdministratorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public OrdinaryAdministratorView(){ }

    public OrdinaryAdministratorView(OrdinaryAdministratorEntity ordinaryAdministratorEntity){
        try {
            BeanUtils.copyProperties(this, ordinaryAdministratorEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
