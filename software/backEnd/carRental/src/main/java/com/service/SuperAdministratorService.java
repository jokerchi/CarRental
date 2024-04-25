package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.SuperAdministratorEntity;
import com.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//超级管理员
@Service("superAdministratorService")
public interface SuperAdministratorService extends IService<SuperAdministratorEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<SuperAdministratorEntity> selectListView(Wrapper<SuperAdministratorEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<SuperAdministratorEntity> wrapper);
}
