package org.example.carrental.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.example.carrental.annotation.IgnoreAuth;
import org.example.carrental.entity.StoreUpEntity;
import org.example.carrental.entity.view.StoreUpView;
import org.example.carrental.service.StoreUpService;
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
@RequestMapping("/storeup")
public class StoreUpController {
    @Autowired
    private StoreUpService storeUpService;
    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, StoreUpEntity store_up,
                  HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            store_up.setUserId((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<StoreUpEntity> ew = new EntityWrapper<StoreUpEntity>();

        PageUtils page = storeUpService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, store_up), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StoreUpEntity store_up,
                  HttpServletRequest request){
        EntityWrapper<StoreUpEntity> ew = new EntityWrapper<StoreUpEntity>();

        PageUtils page = storeUpService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, store_up), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( StoreUpEntity store_up){
        EntityWrapper<StoreUpEntity> ew = new EntityWrapper<StoreUpEntity>();
        ew.allEq(MPUtil.allEQMapPre( store_up, "store_up"));
        return R.ok().put("data", storeUpService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StoreUpEntity store_up){
        EntityWrapper< StoreUpEntity> ew = new EntityWrapper< StoreUpEntity>();
        ew.allEq(MPUtil.allEQMapPre( store_up, "store_up"));
        StoreUpView storeupView =  storeUpService.selectView(ew);
        return R.ok("查询收藏表成功").put("data", storeupView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreUpEntity storeUp = storeUpService.selectById(id);
        return R.ok().put("data", storeUp);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StoreUpEntity storeUp = storeUpService.selectById(id);
        return R.ok().put("data", storeUp);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreUpEntity store_up, HttpServletRequest request){
        store_up.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        store_up.setUserId((Long)request.getSession().getAttribute("user_id"));
        storeUpService.insert(store_up);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody StoreUpEntity store_up, HttpServletRequest request){
        store_up.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        storeUpService.insert(store_up);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody StoreUpEntity store_up, HttpServletRequest request){
        storeUpService.updateById(store_up);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeUpService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<StoreUpEntity> wrapper = new EntityWrapper<StoreUpEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            wrapper.eq("user_id", (Long)request.getSession().getAttribute("user_id"));
        }


        int count = storeUpService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
