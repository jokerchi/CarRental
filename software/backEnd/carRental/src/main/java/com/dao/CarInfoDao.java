package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.CarInfoEntity;
import com.entity.view.CarInfoView;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper //不加mapper无法自动注入
public interface CarInfoDao  extends BaseMapper<CarInfoEntity> {
    List<CarInfoEntity> selectListVO(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    static CarInfoEntity selectVO2(@Param("ew") Wrapper<CarInfoEntity> wrapper) {
        return new CarInfoEntity();
    }

    CarInfoEntity selectVO(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    List<CarInfoView> selectListView(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    List<CarInfoView> selectListView(Pagination page, @Param("ew") Wrapper<CarInfoEntity> wrapper);

    CarInfoView selectView(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    @Update("update carinfo set status=#{status} where car_number=#{carNumber}")
    public int updateStatus(CarInfoEntity carInfo);
}
