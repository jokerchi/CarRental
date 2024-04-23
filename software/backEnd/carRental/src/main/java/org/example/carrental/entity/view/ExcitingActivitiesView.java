package org.example.carrental.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import org.example.carrental.entity.ExcitingActivitiesEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("exciting_activities")
public class ExcitingActivitiesView extends ExcitingActivitiesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public ExcitingActivitiesView(){
    }

    public ExcitingActivitiesView(ExcitingActivitiesEntity excitingActivitiesEntity) {
        try {
            BeanUtils.copyProperties(this, excitingActivitiesEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
