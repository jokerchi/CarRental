package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.ReturnCarInfoDao;
import org.example.carrental.entity.ReturnCarInfoEntity;
import org.example.carrental.entity.view.ReturnCarInfoView;
import org.example.carrental.service.ReturnCarInfoService;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("returnCarInfoService")
public class ReturnCarInfoServiceImpl extends ServiceImpl<ReturnCarInfoDao, ReturnCarInfoEntity> implements ReturnCarInfoService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReturnCarInfoEntity> page = this.selectPage(
                new Query<ReturnCarInfoEntity>(params).getPage(),
                new EntityWrapper<ReturnCarInfoEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ReturnCarInfoEntity> wrapper) {
        Page<ReturnCarInfoView> page =new Query<ReturnCarInfoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ReturnCarInfoEntity> selectListVO(Wrapper<ReturnCarInfoEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ReturnCarInfoEntity selectVO(Wrapper<ReturnCarInfoEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ReturnCarInfoView> selectListView(Wrapper<ReturnCarInfoEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ReturnCarInfoView selectView(Wrapper<ReturnCarInfoEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
