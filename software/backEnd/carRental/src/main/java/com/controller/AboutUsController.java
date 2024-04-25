package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.AboutUsEntity;
import com.entity.view.AboutUsView;
import com.service.AboutUsService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
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
@RequestMapping("/aboutus")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutusService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, AboutUsEntity aboutus,
                  HttpServletRequest request){
        EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();

        PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));

        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AboutUsEntity aboutus,
                  HttpServletRequest request){
        EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();

        PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R list( AboutUsEntity aboutus){
        EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();
        ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus"));
        return R.ok().put("data", aboutusService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(AboutUsEntity aboutus){
        EntityWrapper< AboutUsEntity> ew = new EntityWrapper< AboutUsEntity>();
        ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus"));
        AboutUsView aboutusView =  aboutusService.selectView(ew);
        return R.ok("查询关于我们成功").put("data", aboutusView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AboutUsEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }

    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AboutUsEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }


    @RequestMapping("/save")
    public R save(@RequestBody AboutUsEntity aboutus, HttpServletRequest request){
        aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(aboutus);
        aboutusService.insert(aboutus);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody AboutUsEntity aboutus, HttpServletRequest request){
        aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(aboutus);
        aboutusService.insert(aboutus);
        return R.ok();
    }


    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AboutUsEntity aboutus, HttpServletRequest request){
        //ValidatorUtils.validateEntity(aboutus);
        aboutusService.updateById(aboutus);//全部更新
        return R.ok();
    }


    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        aboutusService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

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

        Wrapper<AboutUsEntity> wrapper = new EntityWrapper<AboutUsEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }


        int count = aboutusService.selectCount(wrapper);
        return R.ok().put("count", count);
    }

}
