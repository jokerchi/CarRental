package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.TokenDao;
import org.example.carrental.entity.TokenEntity;
import org.example.carrental.service.TokenService;
import org.example.carrental.utils.CommonUtil;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TokenEntity> page = this.selectPage(
                new Query<TokenEntity>(params).getPage(),
                new EntityWrapper<TokenEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params,
                               Wrapper<TokenEntity> wrapper) {
        Page<TokenEntity> page =new Query<TokenEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public String generateToken(Long user_id,String user_name, String table_name, String role) {
        TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("user_id", user_id).eq("role", role));
        String token = CommonUtil.getRandomString(32);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 1);
        if(tokenEntity!=null) {
            tokenEntity.setToken(token);
            tokenEntity.setExpiratedTime(cal.getTime());
            this.updateById(tokenEntity);
        } else {
            this.insert(new TokenEntity(user_id,user_name, table_name, role, token, cal.getTime()));
        }
        return token;
    }

    @Override
    public TokenEntity getTokenEntity(String token) {
        TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
        if(tokenEntity == null || tokenEntity.getExpiratedTime().getTime()<new Date().getTime()) {
            return null;
        }
        return tokenEntity;
    }
}
