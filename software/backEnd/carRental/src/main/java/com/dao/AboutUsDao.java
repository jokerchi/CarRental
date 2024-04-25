package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.AboutUsEntity;
import com.entity.view.AboutUsView;
import com.entity.vo.AboutUsVO;

import java.util.List;
@Mapper

public interface AboutUsDao extends BaseMapper<AboutUsEntity> {

    List<AboutUsVO> selectListVO(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    AboutUsVO selectVO(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    List<AboutUsView> selectListView(@Param("ew") Wrapper<AboutUsEntity> wrapper);

    List<AboutUsView> selectListView(Pagination page, @Param("ew") Wrapper<AboutUsEntity> wrapper);

    AboutUsView selectView(@Param("ew") Wrapper<AboutUsEntity> wrapper);
}
