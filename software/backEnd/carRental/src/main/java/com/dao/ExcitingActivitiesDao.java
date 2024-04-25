package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.ExcitingActivitiesEntity;
import com.entity.view.ExcitingActivitiesView;
import com.entity.vo.ExcitingActivitiesVO;

import java.util.List;

public interface ExcitingActivitiesDao extends BaseMapper<ExcitingActivitiesEntity>{

    List<ExcitingActivitiesVO> selectListVO(@Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);

    ExcitingActivitiesVO selectVO(@Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);

    List<ExcitingActivitiesView> selectListView(@Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);

    List<ExcitingActivitiesView> selectListView(Pagination page, @Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);

    ExcitingActivitiesView selectView(@Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);
}
