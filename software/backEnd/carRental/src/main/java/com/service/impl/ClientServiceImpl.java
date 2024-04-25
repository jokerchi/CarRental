package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ClientDao;
import com.entity.ClientEntity;
import com.entity.view.ClientView;
import com.service.ClientService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("clientService")
public class ClientServiceImpl extends ServiceImpl<ClientDao, ClientEntity> implements ClientService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClientEntity> page = this.selectPage(
                new Query<ClientEntity>(params).getPage(),
                new EntityWrapper<ClientEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ClientEntity> wrapper) {
        Page<ClientView> page =new Query<ClientView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ClientEntity> selectListVO(Wrapper<ClientEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ClientEntity selectVO(Wrapper<ClientEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ClientView> selectListView(Wrapper<ClientEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ClientView selectView(Wrapper<ClientEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
