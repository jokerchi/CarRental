package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ExcitingActivitiesEntity;
import com.entity.view.ExcitingActivitiesView;
import com.entity.vo.ExcitingActivitiesVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExcitingActivitiesService extends IService<ExcitingActivitiesEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ExcitingActivitiesVO> selectListVO(Wrapper<ExcitingActivitiesEntity> wrapper);

    ExcitingActivitiesVO selectVO(@Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);

    List<ExcitingActivitiesView> selectListView(Wrapper<ExcitingActivitiesEntity> wrapper);

    ExcitingActivitiesView selectView(@Param("ew") Wrapper<ExcitingActivitiesEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ExcitingActivitiesEntity> wrapper);

}
