package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.example.carrental.entity.AboutUsEntity;
import org.example.carrental.entity.view.AboutUsView;
import org.example.carrental.entity.vo.AboutUsVO;
import org.example.carrental.utils.PageUtils;

import java.util.Map;

public interface AboutUsService extends IService<AboutUsEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<AboutUsVO> selectListVO(Wrapper<AboutUsEntity> wrapper);

    AboutUsVO selectVO(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    List<AboutUsView> selectListView(Wrapper<AboutUsEntity> wrapper);

    AboutUsView selectView(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<AboutUsEntity> wrapper);
}
