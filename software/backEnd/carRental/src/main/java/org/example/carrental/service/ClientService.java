package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.ClientEntity;
import org.example.carrental.entity.view.ClientView;
import org.example.carrental.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface ClientService extends IService<ClientEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ClientEntity> selectListVO(Wrapper<ClientEntity> wrapper);

    ClientEntity selectVO(@Param("ew") Wrapper<ClientEntity> wrapper);

    List<ClientView> selectListView(Wrapper<ClientEntity> wrapper);

    ClientView selectView(@Param("ew") Wrapper<ClientEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ClientEntity> wrapper);
}
