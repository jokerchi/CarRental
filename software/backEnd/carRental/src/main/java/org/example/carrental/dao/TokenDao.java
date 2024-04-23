package org.example.carrental.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.example.carrental.entity.TokenEntity;

import java.util.List;

public interface TokenDao extends BaseMapper<TokenEntity> {
    List<TokenEntity> selectListView(@Param("ew") Wrapper<TokenEntity> wrapper);

    List<TokenEntity> selectListView(Pagination page, @Param("ew") Wrapper<TokenEntity> wrapper);
}
