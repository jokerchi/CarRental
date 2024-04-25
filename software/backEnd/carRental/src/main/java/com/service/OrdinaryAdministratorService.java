package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.OrdinaryAdministratorEntity;
import com.entity.view.OrdinaryAdministratorView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdinaryAdministratorService extends IService<OrdinaryAdministratorEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<OrdinaryAdministratorEntity> selectListVO(Wrapper<OrdinaryAdministratorEntity> wrapper);

    OrdinaryAdministratorEntity selectVO(@Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);

    List<OrdinaryAdministratorView> selectListView(Wrapper<OrdinaryAdministratorEntity> wrapper);

    OrdinaryAdministratorView selectView(@Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<OrdinaryAdministratorEntity> wrapper);
}
