package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CarRentalOrderEntity;
import com.entity.view.CarRentalOrderView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

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
