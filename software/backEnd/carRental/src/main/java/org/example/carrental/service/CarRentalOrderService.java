package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.CarRentalOrderEntity;
import org.example.carrental.entity.view.CarRentalOrderView;
import org.example.carrental.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface CarRentalOrderService extends IService<CarRentalOrderEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<CarRentalOrderEntity> selectListVO(Wrapper<CarRentalOrderEntity> wrapper);

    CarRentalOrderEntity selectVO(@Param("ew") Wrapper<CarRentalOrderEntity> wrapper);

    List<CarRentalOrderView> selectListView(Wrapper<CarRentalOrderEntity> wrapper);

    CarRentalOrderView selectView(@Param("ew") Wrapper<CarRentalOrderEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<CarRentalOrderEntity> wrapper);

}
