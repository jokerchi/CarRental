package org.example.carrental.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.OrdinaryAdministratorEntity;
import org.example.carrental.entity.view.OrdinaryAdministratorView;

import java.util.List;

//普通管理员
public interface OrdinaryAdministratorDao extends BaseMapper<OrdinaryAdministratorEntity> {
    List<OrdinaryAdministratorEntity> selectListVO(@Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);

    OrdinaryAdministratorEntity selectVO(@Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);

    List<OrdinaryAdministratorView> selectListView(@Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);

    List<OrdinaryAdministratorView> selectListView(Pagination page, @Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);

    OrdinaryAdministratorView selectView(@Param("ew") Wrapper<OrdinaryAdministratorEntity> wrapper);
}
