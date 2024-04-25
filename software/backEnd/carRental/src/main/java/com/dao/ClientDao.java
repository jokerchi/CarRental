package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.ClientEntity;
import com.entity.view.ClientView;

import java.util.List;

public interface ClientDao extends BaseMapper<ClientEntity> {
    List<ClientEntity> selectListVO(@Param("ew") Wrapper<ClientEntity> wrapper);

    ClientEntity selectVO(@Param("ew") Wrapper<ClientEntity> wrapper);

    List<ClientView> selectListView(@Param("ew") Wrapper<ClientEntity> wrapper);

    List<ClientView> selectListView(Pagination page, @Param("ew") Wrapper<ClientEntity> wrapper);

    ClientView selectView(@Param("ew") Wrapper<ClientEntity> wrapper);
}
