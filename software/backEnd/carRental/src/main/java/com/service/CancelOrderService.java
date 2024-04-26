package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CancelOrderEntity;
import com.entity.view.CancelOrderView;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

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
