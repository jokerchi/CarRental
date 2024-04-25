package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.view.ForumView;
import org.apache.ibatis.annotations.Param;
import com.entity.ForumEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface ForumService extends IService<ForumEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ForumEntity> selectListVO(Wrapper<ForumEntity> wrapper);

    ForumEntity selectVO(@Param("ew") Wrapper<ForumEntity> wrapper);

    List<ForumView> selectListView(Wrapper<ForumEntity> wrapper);

    ForumView selectView(@Param("ew") Wrapper<ForumEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ForumEntity> wrapper);
}
