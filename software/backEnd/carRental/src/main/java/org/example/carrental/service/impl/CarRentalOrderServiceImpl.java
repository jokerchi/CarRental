package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.CarRentalOrderDao;
import org.example.carrental.entity.CarRentalOrderEntity;
import org.example.carrental.entity.view.CarRentalOrderView;
import org.example.carrental.service.CarRentalOrderService;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("carRentalService")
public class CarRentalOrderServiceImpl extends ServiceImpl<CarRentalOrderDao, CarRentalOrderEntity> implements CarRentalOrderService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CarRentalOrderEntity> page = this.selectPage(
                new Query<CarRentalOrderEntity>(params).getPage(),
                new EntityWrapper<CarRentalOrderEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CarRentalOrderEntity> wrapper) {
        Page<CarRentalOrderView> page =new Query<CarRentalOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<CarRentalOrderEntity> selectListVO(Wrapper<CarRentalOrderEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public CarRentalOrderEntity selectVO(Wrapper<CarRentalOrderEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<CarRentalOrderView> selectListView(Wrapper<CarRentalOrderEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public CarRentalOrderView selectView(Wrapper<CarRentalOrderEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
