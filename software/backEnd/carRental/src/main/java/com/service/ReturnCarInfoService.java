package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ReturnCarInfoEntity;
import com.entity.view.ReturnCarInfoView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReturnCarInfoService extends IService<ReturnCarInfoEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ReturnCarInfoEntity> selectListVO(Wrapper<ReturnCarInfoEntity> wrapper);

    ReturnCarInfoEntity selectVO(@Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);

    List<ReturnCarInfoView> selectListView(Wrapper<ReturnCarInfoEntity> wrapper);

    ReturnCarInfoView selectView(@Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ReturnCarInfoEntity> wrapper);
}
