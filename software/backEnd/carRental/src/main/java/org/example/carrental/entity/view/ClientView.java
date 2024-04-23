package org.example.carrental.entity.view;

import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.ClientEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class ClientView  extends ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientView(){
    }

    public ClientView(ClientEntity clientEntity){
        try {
            BeanUtils.copyProperties(this, clientEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
