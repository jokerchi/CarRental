package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.example.carrental.entity.ConfigEntity;
import org.example.carrental.utils.PageUtils;

import java.util.Map;

//系统用户
public interface ConfigService extends IService<ConfigEntity> {
    PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper);
}
