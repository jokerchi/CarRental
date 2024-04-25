package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ReturnCarInfoEntity;
import com.entity.view.ReturnCarInfoView;
import com.service.ReturnCarInfoService;
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
@RequestMapping("/returncarinfo")
public class ReturnCarInfoController {
    @Autowired
    private ReturnCarInfoService returnCarInfoService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ReturnCarInfoEntity returnCarInfo,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("client")) {
            returnCarInfo.setClientAccount((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ordinaryadministrator")) {
            returnCarInfo.setAdminAccount((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ReturnCarInfoEntity> ew = new EntityWrapper<ReturnCarInfoEntity>();

        PageUtils page = returnCarInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, returnCarInfo), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ReturnCarInfoEntity returnCarInfo,
                  HttpServletRequest request){
        EntityWrapper<ReturnCarInfoEntity> ew = new EntityWrapper<ReturnCarInfoEntity>();

        PageUtils page = returnCarInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, returnCarInfo), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ReturnCarInfoEntity returnCarInfo){
        EntityWrapper<ReturnCarInfoEntity> ew = new EntityWrapper<ReturnCarInfoEntity>();
        ew.allEq(MPUtil.allEQMapPre( returnCarInfo, "returnCarInfo"));
        return R.ok().put("data", returnCarInfoService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ReturnCarInfoEntity returnCarInfo){
        EntityWrapper< ReturnCarInfoEntity> ew = new EntityWrapper< ReturnCarInfoEntity>();
        ew.allEq(MPUtil.allEQMapPre( returnCarInfo, "returnCarInfo"));
        ReturnCarInfoView returnCarInfoView =  returnCarInfoService.selectView(ew);
        return R.ok("查询还车信息成功").put("data", returnCarInfoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ReturnCarInfoEntity returnCarInfo = returnCarInfoService.selectById(id);
        return R.ok().put("data", returnCarInfo);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ReturnCarInfoEntity returnCarInfo = returnCarInfoService.selectById(id);
        return R.ok().put("data", returnCarInfo);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ReturnCarInfoEntity returnCarInfo, HttpServletRequest request){
        returnCarInfo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        returnCarInfoService.insert(returnCarInfo);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ReturnCarInfoEntity returnCarInfo, HttpServletRequest request){
        returnCarInfo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        returnCarInfoService.insert(returnCarInfo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ReturnCarInfoEntity returnCarInfo, HttpServletRequest request){
        returnCarInfoService.updateById(returnCarInfo);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        returnCarInfoService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<ReturnCarInfoEntity> wrapper = new EntityWrapper<ReturnCarInfoEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("client")) {
            wrapper.eq("account", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ordinaryadministrator")) {
            wrapper.eq("ordinary_admin_account", (String)request.getSession().getAttribute("username"));
        }

        int count = returnCarInfoService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
