package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.StoreUpEntity;
import com.entity.view.StoreUpView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StoreUpService extends IService<StoreUpEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<StoreUpEntity> selectListVO(Wrapper<StoreUpEntity> wrapper);

    StoreUpEntity selectVO(@Param("ew") Wrapper<StoreUpEntity> wrapper);

    List<StoreUpView> selectListView(Wrapper<StoreUpEntity> wrapper);

    StoreUpView selectView(@Param("ew") Wrapper<StoreUpEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<StoreUpEntity> wrapper);
}
