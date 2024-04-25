package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.SuperAdministratorDao;
import com.entity.SuperAdministratorEntity;
import com.service.SuperAdministratorService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("superAdministratorService")
public class SuperAdministratorServiceImpl extends ServiceImpl<SuperAdministratorDao, SuperAdministratorEntity> implements SuperAdministratorService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SuperAdministratorEntity> page = this.selectPage(
                new Query<SuperAdministratorEntity>(params).getPage(),
                new EntityWrapper<SuperAdministratorEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<SuperAdministratorEntity> selectListView(Wrapper<SuperAdministratorEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params,
                               Wrapper<SuperAdministratorEntity> wrapper) {
        Page<SuperAdministratorEntity> page =new Query<SuperAdministratorEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
