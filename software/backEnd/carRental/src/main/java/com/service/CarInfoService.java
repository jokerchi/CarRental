package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CarInfoEntity;
import com.entity.view.CarInfoView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarInfoService extends IService<CarInfoEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<CarInfoEntity> selectListVO(Wrapper<CarInfoEntity> wrapper);

    CarInfoEntity selectVO(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    List<CarInfoView> selectListView(Wrapper<CarInfoEntity> wrapper);

    CarInfoView selectView(@Param("ew") Wrapper<CarInfoEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<CarInfoEntity> wrapper);
}
