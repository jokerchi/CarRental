package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.CarRentalOrderEntity;
import com.entity.view.CarRentalOrderView;

import java.util.List;

public interface CarRentalOrderDao extends BaseMapper<CarRentalOrderEntity> {
        List<CarRentalOrderEntity> selectListVO(@Param("ew") Wrapper<CarRentalOrderEntity> wrapper);

        CarRentalOrderEntity selectVO(@Param("ew") Wrapper<CarRentalOrderEntity> wrapper);

        List<CarRentalOrderView> selectListView(@Param("ew") Wrapper<CarRentalOrderEntity> wrapper);

        List<CarRentalOrderView> selectListView(Pagination page, @Param("ew") Wrapper<CarRentalOrderEntity> wrapper);

        CarRentalOrderView selectView(@Param("ew") Wrapper<CarRentalOrderEntity> wrapper);
}
