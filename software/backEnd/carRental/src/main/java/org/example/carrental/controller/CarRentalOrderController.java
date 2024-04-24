package org.example.carrental.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.example.carrental.annotation.IgnoreAuth;
import org.example.carrental.entity.CarRentalOrderEntity;
import org.example.carrental.entity.view.CarRentalOrderView;
import org.example.carrental.service.CarRentalOrderService;
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
@RequestMapping("/carrentalorder")
public class CarRentalOrderController {
    @Autowired
    private CarRentalOrderService carRentalOrderService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CarRentalOrderEntity carRentalOrder,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("client")) {
            carRentalOrder.setClientAccount((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("ordinaryadministrator")) {
            carRentalOrder.setAdministratorAccount((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<CarRentalOrderEntity> ew = new EntityWrapper<CarRentalOrderEntity>();

        PageUtils page = carRentalOrderService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, carRentalOrder), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CarRentalOrderEntity carRentalOrder,
                  HttpServletRequest request){
        EntityWrapper<CarRentalOrderEntity> ew = new EntityWrapper<CarRentalOrderEntity>();

        PageUtils page = carRentalOrderService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, carRentalOrder), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CarRentalOrderEntity carRentalOrder){
        EntityWrapper<CarRentalOrderEntity> ew = new EntityWrapper<CarRentalOrderEntity>();
        ew.allEq(MPUtil.allEQMapPre( carRentalOrder, "carRentalOrder"));
        return R.ok().put("data", carRentalOrderService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CarRentalOrderEntity carRentalOrder){
        EntityWrapper< CarRentalOrderEntity> ew = new EntityWrapper< CarRentalOrderEntity>();
        ew.allEq(MPUtil.allEQMapPre( carRentalOrder, "carRentalOrder"));
        CarRentalOrderView carRentalOrderView =  carRentalOrderService.selectView(ew);
        return R.ok("查询租车订单成功").put("data", carRentalOrderView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CarRentalOrderEntity carRentalOrder = carRentalOrderService.selectById(id);
        return R.ok().put("data", carRentalOrder);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CarRentalOrderEntity carRentalOrder = carRentalOrderService.selectById(id);
        return R.ok().put("data", carRentalOrder);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CarRentalOrderEntity carRentalOrder, HttpServletRequest request){
        carRentalOrder.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(zuchedingdan);
        carRentalOrderService.insert(carRentalOrder);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody CarRentalOrderEntity carRentalOrder, HttpServletRequest request){
        carRentalOrder.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        carRentalOrderService.insert(carRentalOrder);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CarRentalOrderEntity carRentalOrder, HttpServletRequest request){
        carRentalOrderService.updateById(carRentalOrder);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        carRentalOrderService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<CarRentalOrderEntity> wrapper = new EntityWrapper<CarRentalOrderEntity>();
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

        int count = carRentalOrderService.selectCount(wrapper);
        return R.ok().put("count", count);
    }

}
