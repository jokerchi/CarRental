package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.StoreUpDao;
import com.entity.StoreUpEntity;
import com.entity.view.StoreUpView;
import com.service.StoreUpService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("storeUpService")
public class StoreUpServiceImpl extends ServiceImpl<StoreUpDao, StoreUpEntity> implements StoreUpService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StoreUpEntity> page = this.selectPage(
                new Query<StoreUpEntity>(params).getPage(),
                new EntityWrapper<StoreUpEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<StoreUpEntity> wrapper) {
        Page<StoreUpView> page =new Query<StoreUpView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<StoreUpEntity> selectListVO(Wrapper<StoreUpEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public StoreUpEntity selectVO(Wrapper<StoreUpEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<StoreUpView> selectListView(Wrapper<StoreUpEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public StoreUpView selectView(Wrapper<StoreUpEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
