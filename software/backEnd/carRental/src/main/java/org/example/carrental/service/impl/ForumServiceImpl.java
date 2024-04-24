package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.example.carrental.dao.ForumDao;
import org.example.carrental.entity.ForumEntity;
import org.example.carrental.entity.view.ForumView;
import org.example.carrental.service.ForumService;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("forumService")
public class ForumServiceImpl extends ServiceImpl<ForumDao, ForumEntity> implements ForumService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForumEntity> page = this.selectPage(
                new Query<ForumEntity>(params).getPage(),
                new EntityWrapper<ForumEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ForumEntity> wrapper) {
        Page<ForumView> page =new Query<ForumView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ForumEntity> selectListVO(Wrapper<ForumEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ForumEntity selectVO(Wrapper<ForumEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ForumView> selectListView(Wrapper<ForumEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ForumView selectView(Wrapper<ForumEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
