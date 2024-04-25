package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AboutUsEntity;
import com.entity.view.AboutUsView;
import com.entity.vo.AboutUsVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import java.util.Map;

public interface AboutUsService extends IService<AboutUsEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<AboutUsVO> selectListVO(Wrapper<AboutUsEntity> wrapper);

    AboutUsVO selectVO(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    List<AboutUsView> selectListView(Wrapper<AboutUsEntity> wrapper);

    AboutUsView selectView(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<AboutUsEntity> wrapper);
}
