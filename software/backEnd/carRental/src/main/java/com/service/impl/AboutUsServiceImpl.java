package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AboutUsDao;
import com.entity.AboutUsEntity;
import com.entity.view.AboutUsView;
import com.entity.vo.AboutUsVO;
import com.service.AboutUsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("aboutUsService")
public class AboutUsServiceImpl extends ServiceImpl<AboutUsDao, AboutUsEntity> implements AboutUsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AboutUsEntity> page = this.selectPage(
                new Query<AboutUsEntity>(params).getPage(),
                new EntityWrapper<AboutUsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<AboutUsEntity> wrapper) {
        Page<AboutUsView> page = new Query<AboutUsView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<AboutUsVO> selectListVO(Wrapper<AboutUsEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public AboutUsVO selectVO(Wrapper<AboutUsEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<AboutUsView> selectListView(Wrapper<AboutUsEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public AboutUsView selectView(Wrapper<AboutUsEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
