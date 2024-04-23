package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.ExcitingActivitiesEntity;
import org.example.carrental.entity.view.ExcitingActivitiesView;
import org.example.carrental.entity.vo.ExcitingActivitiesVO;
import org.example.carrental.utils.PageUtils;

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
