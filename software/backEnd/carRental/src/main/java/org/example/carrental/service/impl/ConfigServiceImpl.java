package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.ConfigDao;
import org.example.carrental.entity.ConfigEntity;
import org.example.carrental.service.ConfigService;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper) {
        Page<ConfigEntity> page = this.selectPage(
                new Query<ConfigEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }
}
