package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ClientEntity;
import com.entity.view.ClientView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("clientService")
public interface ClientService extends IService<ClientEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ClientEntity> selectListVO(Wrapper<ClientEntity> wrapper);

    ClientEntity selectVO(@Param("ew") Wrapper<ClientEntity> wrapper);

    List<ClientView> selectListView(Wrapper<ClientEntity> wrapper);

    ClientView selectView(@Param("ew") Wrapper<ClientEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ClientEntity> wrapper);
}
