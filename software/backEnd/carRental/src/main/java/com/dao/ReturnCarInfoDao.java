package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.ReturnCarInfoEntity;
import com.entity.view.ReturnCarInfoView;

import java.util.List;

public interface ReturnCarInfoDao extends BaseMapper<ReturnCarInfoEntity> {
    List<ReturnCarInfoEntity> selectListVO(@Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);

    ReturnCarInfoEntity selectVO(@Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);

    List<ReturnCarInfoView> selectListView(@Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);

    List<ReturnCarInfoView> selectListView(Pagination page, @Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);

    ReturnCarInfoView selectView(@Param("ew") Wrapper<ReturnCarInfoEntity> wrapper);
}
