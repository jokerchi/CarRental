package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.StoreUpEntity;
import org.example.carrental.entity.view.StoreUpView;
import org.example.carrental.utils.PageUtils;

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
