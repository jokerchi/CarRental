package org.example.carrental.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.CancelOrderEntity;
import org.example.carrental.entity.view.CancelOrderView;

import java.util.List;

public interface CancelOrderDao extends BaseMapper<CancelOrderEntity> {
    List<CancelOrderEntity> selectListVO(@Param("ew") Wrapper<CancelOrderEntity> wrapper);

    CancelOrderEntity selectVO(@Param("ew") Wrapper<CancelOrderEntity> wrapper);

    List<CancelOrderView> selectListView(@Param("ew") Wrapper<CancelOrderEntity> wrapper);

    List<CancelOrderView> selectListView(Pagination page, @Param("ew") Wrapper<CancelOrderEntity> wrapper);

    CancelOrderView selectView(@Param("ew") Wrapper<CancelOrderEntity> wrapper);
}
