package org.example.carrental.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.example.carrental.annotation.IgnoreAuth;
import org.example.carrental.entity.ForumEntity;
import org.example.carrental.entity.view.ForumView;
import org.example.carrental.service.ForumService;
import org.example.carrental.utils.MPUtil;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ForumEntity forum,
                  HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            forum.setUserId((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();

        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ForumEntity forum,
                  HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            forum.setUserId((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();

        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @IgnoreAuth
    @RequestMapping("/flist")
    public R flist(@RequestParam Map<String, Object> params,ForumEntity forum, HttpServletRequest request){
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ForumEntity forum){
        EntityWrapper< ForumEntity> ew = new EntityWrapper< ForumEntity>();
        ew.allEq(MPUtil.allEQMapPre( forum, "forum"));
        ForumView forumView =  forumService.selectView(ew);
        return R.ok("查询汽车论坛成功").put("data", forumView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ForumEntity forum = forumService.selectById(id);
        return R.ok().put("data", forum);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ForumEntity forum = forumService.selectById(id);
        return R.ok().put("data", forum);
    }

    /**
     * 论坛详情
     */
    @IgnoreAuth
    @RequestMapping("/list/{id}")
    public R list(@PathVariable("id") String id){
        ForumEntity forum = forumService.selectById(id);
        getChilds(forum);
        return R.ok().put("data", forum);
    }

    private ForumEntity getChilds(ForumEntity forum) {
        List<ForumEntity> childs = new ArrayList<ForumEntity>();
        childs = forumService.selectList(new EntityWrapper<ForumEntity>().eq("parent_id", forum.getId()));
        if(childs == null || childs.size()==0) {
            return null;
        }
        forum.setChilds(childs);
        for(ForumEntity forumEntity : childs) {
            getChilds(forumEntity);
        }
        return forum;
    }



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ForumEntity forum, HttpServletRequest request){
        forum.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(forum);
        forum.setUserId((Long)request.getSession().getAttribute("userId"));
        forumService.insert(forum);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ForumEntity forum, HttpServletRequest request){
        forum.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(forum);
        forum.setUserId((Long)request.getSession().getAttribute("userId"));
        forumService.insert(forum);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ForumEntity forum, HttpServletRequest request){
        //ValidatorUtils.validateEntity(forum);
        forumService.updateById(forum);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        forumService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if(type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if(map.get("remindstart")!=null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if(map.get("remindend")!=null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<ForumEntity> wrapper = new EntityWrapper<ForumEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }


        int count = forumService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}