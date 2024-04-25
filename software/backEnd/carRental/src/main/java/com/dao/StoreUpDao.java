package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.StoreUpEntity;
import com.entity.view.StoreUpView;

import java.util.List;

public interface StoreUpDao extends BaseMapper<StoreUpEntity> {
    List<StoreUpEntity> selectListVO(@Param("ew") Wrapper<StoreUpEntity> wrapper);

    StoreUpEntity selectVO(@Param("ew") Wrapper<StoreUpEntity> wrapper);

    List<StoreUpView> selectListView(@Param("ew") Wrapper<StoreUpEntity> wrapper);

    List<StoreUpView> selectListView(Pagination page, @Param("ew") Wrapper<StoreUpEntity> wrapper);

    StoreUpView selectView(@Param("ew") Wrapper<StoreUpEntity> wrapper);
}
