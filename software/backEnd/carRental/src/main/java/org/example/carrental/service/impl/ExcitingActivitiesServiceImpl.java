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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("excitingactivitiesService")
public class ExcitingActivitiesServiceImpl extends ServiceImpl<ExcitingActivitiesDao, ExcitingActivitiesEntity> implements ExcitingActivitiesService {

    @Autowired
    private ExcitingActivitiesDao excitingActivitiesDao;

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
        System.out.println("testing");
        page.setRecords(excitingActivitiesDao.selectPageListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ExcitingActivitiesVO> selectListVO(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return excitingActivitiesDao.selectListVO(wrapper);
    }

    @Override
    public ExcitingActivitiesVO selectVO(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return excitingActivitiesDao.selectVO(wrapper);
    }

    @Override
    public List<ExcitingActivitiesView> selectListView(Wrapper<ExcitingActivitiesEntity> wrapper) {
//        return excitingActivitiesDao.selectListView(wrapper);
        return null;
    }

    @Override
    public ExcitingActivitiesView selectView(Wrapper<ExcitingActivitiesEntity> wrapper) {
        return excitingActivitiesDao.selectView(wrapper);
    }


}