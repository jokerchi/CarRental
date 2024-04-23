package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.example.carrental.entity.SuperAdministratorEntity;
import org.example.carrental.utils.PageUtils;
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
