package org.example.carrental.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.ExcitingActivitiesDao;
import org.example.carrental.entity.ExcitingActivitiesEntity;
import org.example.carrental.entity.view.ExcitingActivitiesView;
import org.example.carrental.entity.vo.ExcitingActivitiesVO;
import org.example.carrental.service.ExcitingActivitiesService;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("excitingActivitiesService")
public class ExcitingActivitiesServiceImpl extends ServiceImpl<ExcitingActivitiesDao, ExcitingActivitiesEntity> implements ExcitingActivitiesService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExcitingActivitiesEntity> page = this.selectPage(
                new Query<ExcitingActivitiesEntity>(params).getPage(),
                new EntityWrapper<ExcitingActivitiesEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ExcitingActivitiesEntity> wrapper) {
        Page<ExcitingActivitiesView> page =new Query<ExcitingActivitiesView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ExcitingActivitiesVO> selectListVO(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ExcitingActivitiesVO selectVO(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ExcitingActivitiesView> selectListView(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ExcitingActivitiesView selectView(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}