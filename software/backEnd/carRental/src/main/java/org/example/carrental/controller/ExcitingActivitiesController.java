package org.example.carrental.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.example.carrental.annotation.IgnoreAuth;
import org.example.carrental.entity.ExcitingActivitiesEntity;
import org.example.carrental.entity.view.ExcitingActivitiesView;
import org.example.carrental.service.ExcitingActivitiesService;
import org.example.carrental.utils.MPUtil;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/excitingActivities")
public class ExcitingActivitiesController {
    @Autowired
    private ExcitingActivitiesService excitingActivitiesService;





    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ExcitingActivitiesEntity news,
                  HttpServletRequest request){
        EntityWrapper<ExcitingActivitiesEntity> ew = new EntityWrapper<ExcitingActivitiesEntity>();

        PageUtils page = excitingActivitiesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExcitingActivitiesEntity news,
                  HttpServletRequest request){
        EntityWrapper<ExcitingActivitiesEntity> ew = new EntityWrapper<ExcitingActivitiesEntity>();

        PageUtils page = excitingActivitiesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ExcitingActivitiesEntity news){
        EntityWrapper<ExcitingActivitiesEntity> ew = new EntityWrapper<ExcitingActivitiesEntity>();
        ew.allEq(MPUtil.allEQMapPre( news, "news"));
        return R.ok().put("data", excitingActivitiesService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ExcitingActivitiesEntity news){
        EntityWrapper< ExcitingActivitiesEntity> ew = new EntityWrapper< ExcitingActivitiesEntity>();
        ew.allEq(MPUtil.allEQMapPre( news, "news"));
        ExcitingActivitiesView newsView =  excitingActivitiesService.selectView(ew);
        return R.ok("查询公告信息成功").put("data", newsView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExcitingActivitiesEntity news = excitingActivitiesService.selectById(id);
        return R.ok().put("data", news);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExcitingActivitiesEntity news = excitingActivitiesService.selectById(id);
        return R.ok().put("data", news);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExcitingActivitiesEntity news, HttpServletRequest request){
        news.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(news);
        excitingActivitiesService.insert(news);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExcitingActivitiesEntity news, HttpServletRequest request){
        news.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(news);
        excitingActivitiesService.insert(news);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ExcitingActivitiesEntity news, HttpServletRequest request){
        //ValidatorUtils.validateEntity(news);
        excitingActivitiesService.updateById(news);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        excitingActivitiesService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<ExcitingActivitiesEntity> wrapper = new EntityWrapper<ExcitingActivitiesEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }


        int count = excitingActivitiesService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
