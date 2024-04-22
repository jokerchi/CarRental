package org.example.carrental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.carrental.entity.ClientEntity;

@Mapper
public interface ClientDao extends BaseMapper<ClientEntity> {

}
