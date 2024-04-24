package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.ReturnCarInfoEntity;
import org.example.carrental.entity.view.ReturnCarInfoView;
import org.example.carrental.utils.PageUtils;

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
