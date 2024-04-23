package org.example.carrental.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.SuperAdministratorEntity;
import java.util.List;


public interface SuperAdministratorDao extends BaseMapper<SuperAdministratorEntity> {

    List<SuperAdministratorEntity> selectListView(@Param("ew") Wrapper<SuperAdministratorEntity> wrapper);

    List<SuperAdministratorEntity> selectListView(Pagination page, @Param("ew") Wrapper<SuperAdministratorEntity> wrapper);
}
