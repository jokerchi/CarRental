package org.example.carrental.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import org.example.carrental.entity.TokenEntity;
import org.example.carrental.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("tokenService")
public interface TokenService extends IService<TokenEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<TokenEntity> wrapper);

    String generateToken(Long user_id,String user_name,String table_name, String role);

    TokenEntity getTokenEntity(String token);
}
