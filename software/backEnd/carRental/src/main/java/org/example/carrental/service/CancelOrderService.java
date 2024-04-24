package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.CancelOrderEntity;
import org.example.carrental.entity.view.CancelOrderView;
import org.example.carrental.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface CancelOrderService extends IService<CancelOrderEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<CancelOrderEntity> selectListVO(Wrapper<CancelOrderEntity> wrapper);

    CancelOrderEntity selectVO(@Param("ew") Wrapper<CancelOrderEntity> wrapper);

    List<CancelOrderView> selectListView(Wrapper<CancelOrderEntity> wrapper);

    CancelOrderView selectView(@Param("ew") Wrapper<CancelOrderEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<CancelOrderEntity> wrapper);
}
