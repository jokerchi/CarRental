package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.OrdinaryAdministratorDao;
import com.entity.OrdinaryAdministratorEntity;
import com.entity.view.OrdinaryAdministratorView;
import com.service.OrdinaryAdministratorService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ordinaryAdministratorService")
public class OrdinaryAdministratorServiceImpl extends ServiceImpl<OrdinaryAdministratorDao, OrdinaryAdministratorEntity> implements OrdinaryAdministratorService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrdinaryAdministratorEntity> page = this.selectPage(
                new Query<OrdinaryAdministratorEntity>(params).getPage(),
                new EntityWrapper<OrdinaryAdministratorEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<OrdinaryAdministratorEntity> wrapper) {
        Page<OrdinaryAdministratorView> page =new Query<OrdinaryAdministratorView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<OrdinaryAdministratorEntity> selectListVO(Wrapper<OrdinaryAdministratorEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public OrdinaryAdministratorEntity selectVO(Wrapper<OrdinaryAdministratorEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<OrdinaryAdministratorView> selectListView(Wrapper<OrdinaryAdministratorEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public OrdinaryAdministratorView selectView(Wrapper<OrdinaryAdministratorEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
