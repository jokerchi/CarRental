package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.dao.CarInfoDao;
import org.apache.commons.lang3.StringUtils;
import com.entity.CarInfoEntity;
import com.entity.view.CarInfoView;
import com.service.CarInfoService;
import com.service.StoreUpService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/carinfo")
public class CarInfoController {
    @Autowired
    private CarInfoService carInfoService;

    @Autowired
    private StoreUpService storeUpService;

    @Autowired //自动注入
    private CarInfoDao carInfoDao;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CarInfoEntity carInfo,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("ordinaryadministrator")) {
            carInfo.setOrdinaryAdminAccount((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<CarInfoEntity> ew = new EntityWrapper<CarInfoEntity>();

        PageUtils page = carInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, carInfo), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CarInfoEntity carInfo,
                  HttpServletRequest request){
        EntityWrapper<CarInfoEntity> ew = new EntityWrapper<CarInfoEntity>();

        PageUtils page = carInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, carInfo), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CarInfoEntity carInfo){
        EntityWrapper<CarInfoEntity> ew = new EntityWrapper<CarInfoEntity>();
        ew.allEq(MPUtil.allEQMapPre( carInfo, "carInfo"));
        return R.ok().put("data", carInfoService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CarInfoEntity carInfo){
        EntityWrapper< CarInfoEntity> ew = new EntityWrapper< CarInfoEntity>();
        ew.allEq(MPUtil.allEQMapPre( carInfo, "carInfo"));
        CarInfoView carInfoView =  carInfoService.selectView(ew);
        return R.ok("查询汽车信息成功").put("data", carInfoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CarInfoEntity carInfo = carInfoService.selectById(id);
        carInfo.setClickNum(carInfo.getClickNum()+1);
        carInfo.setClickTime(new Date());
        carInfoService.updateById(carInfo);
        return R.ok().put("data", carInfo);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CarInfoEntity carInfo = carInfoService.selectById(id);
        carInfo.setClickNum(carInfo.getClickNum()+1);
        carInfo.setClickTime(new Date());
        carInfoService.updateById(carInfo);
        return R.ok().put("data", carInfo);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CarInfoEntity carInfo, HttpServletRequest request){
        carInfo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        carInfoService.insert(carInfo);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CarInfoEntity carInfo, HttpServletRequest request){
        carInfo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        carInfoService.insert(carInfo);
        return R.ok();
    }



    /**
     * 根据id修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CarInfoEntity carInfo, HttpServletRequest request){
        carInfoService.updateById(carInfo);//全部更新
        return R.ok();
    }

    /**
     * 根据车牌号修改汽车信息
     */
    @PostMapping("/update2")
    public R update2(@RequestBody CarInfoEntity carInfo, HttpServletRequest request){
        System.out.println(carInfo);
        int i = carInfoDao.updateStatus(carInfo);//更新汽车状态
        if(i > 0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        carInfoService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<CarInfoEntity> wrapper = new EntityWrapper<CarInfoEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("ordinaryadministrator")) {
            wrapper.eq("ordinary_admin_account", (String)request.getSession().getAttribute("username"));
        }

        int count = carInfoService.selectCount(wrapper);
        return R.ok().put("count", count);
    }

    /**
     * 前端智能排序
     */
    @IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,CarInfoEntity carInfo, HttpServletRequest request,String pre){
        EntityWrapper<CarInfoEntity> ew = new EntityWrapper<CarInfoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            String newKey = entry.getKey();
            if (pre.endsWith(".")) {
                newMap.put(pre + newKey, entry.getValue());
            } else if (StringUtils.isEmpty(pre)) {
                newMap.put(newKey, entry.getValue());
            } else {
                newMap.put(pre + "." + newKey, entry.getValue());
            }
        }
        params.put("sort", "click_num");
        params.put("order", "desc");
        PageUtils page = carInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, carInfo), params), params));
        return R.ok().put("data", page);
    }
}
