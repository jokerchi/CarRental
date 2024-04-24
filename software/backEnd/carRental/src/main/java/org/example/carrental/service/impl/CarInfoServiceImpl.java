package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.CarInfoDao;
import org.example.carrental.entity.CarInfoEntity;
import org.example.carrental.entity.view.CarInfoView;
import org.example.carrental.service.CarInfoService;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("carInfoService")
public class CarInfoServiceImpl extends ServiceImpl<CarInfoDao, CarInfoEntity> implements CarInfoService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CarInfoEntity> page = this.selectPage(
                new Query<CarInfoEntity>(params).getPage(),
                new EntityWrapper<CarInfoEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CarInfoEntity> wrapper) {
        Page<CarInfoView> page =new Query<CarInfoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<CarInfoEntity> selectListVO(Wrapper<CarInfoEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public CarInfoEntity selectVO(Wrapper<CarInfoEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<CarInfoView> selectListView(Wrapper<CarInfoEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public CarInfoView selectView(Wrapper<CarInfoEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
