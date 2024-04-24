package org.example.carrental.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.ForumEntity;
import org.example.carrental.entity.view.ForumView;

import java.util.List;

public interface ForumDao extends BaseMapper<ForumEntity> {
    List<ForumEntity> selectListVO(@Param("ew") Wrapper<ForumEntity> wrapper);

    ForumEntity selectVO(@Param("ew") Wrapper<ForumEntity> wrapper);

    List<ForumView> selectListView(@Param("ew") Wrapper<ForumEntity> wrapper);

    List<ForumView> selectListView(Pagination page, @Param("ew") Wrapper<ForumEntity> wrapper);

    ForumView selectView(@Param("ew") Wrapper<ForumEntity> wrapper);
}
