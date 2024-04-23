package org.example.carrental.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.OrdinaryAdministratorEntity;

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
