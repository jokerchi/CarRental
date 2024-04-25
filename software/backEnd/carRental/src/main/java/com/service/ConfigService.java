package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ConfigEntity;
import com.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

//系统用户
@Service("configService")
public interface ConfigService extends IService<ConfigEntity> {
    PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper);
}
