package org.example.carrental.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.CarInfoEntity;
import org.example.carrental.entity.view.CarInfoView;

import java.util.List;

public interface CarInfoDao  extends BaseMapper<CarInfoEntity> {
    List<CarInfoEntity> selectListVO(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    CarInfoEntity selectVO(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    List<CarInfoView> selectListView(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    List<CarInfoView> selectListView(Pagination page, @Param("ew") Wrapper<CarInfoEntity> wrapper);

    CarInfoView selectView(@Param("ew") Wrapper<CarInfoEntity> wrapper);
}
