package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.OrdinaryAdministratorEntity;
import org.example.carrental.entity.view.OrdinaryAdministratorView;
import org.example.carrental.utils.PageUtils;

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
