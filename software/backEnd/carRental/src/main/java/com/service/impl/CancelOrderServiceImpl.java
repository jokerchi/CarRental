package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.CancelOrderDao;
import com.entity.CancelOrderEntity;
import com.entity.view.CancelOrderView;
import com.service.CancelOrderService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("cancelOrderService")
public class CancelOrderServiceImpl extends ServiceImpl<CancelOrderDao, CancelOrderEntity> implements CancelOrderService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CancelOrderEntity> page = this.selectPage(
                new Query<CancelOrderEntity>(params).getPage(),
                new EntityWrapper<CancelOrderEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CancelOrderEntity> wrapper) {
        Page<CancelOrderView> page =new Query<CancelOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<CancelOrderEntity> selectListVO(Wrapper<CancelOrderEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public CancelOrderEntity selectVO(Wrapper<CancelOrderEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<CancelOrderView> selectListView(Wrapper<CancelOrderEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public CancelOrderView selectView(Wrapper<CancelOrderEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
