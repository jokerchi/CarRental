package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.SuperAdministratorEntity;
import com.service.SuperAdministratorService;
import com.service.TokenService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 登录相关
 */
@RequestMapping("superadministrator")
@RestController
public class SuperAdministratorController {
    @Autowired
    private SuperAdministratorService superAdministratorService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(@RequestParam("username") String super_admin_account, String password, String captcha, HttpServletRequest request) {
        SuperAdministratorEntity super_admin = superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("super_admin_account", super_admin_account));
        if(super_admin==null || !super_admin.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(super_admin.getId(),super_admin_account, "superadministrator", super_admin.getRole());
        return R.ok().put("token", token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SuperAdministratorEntity super_admin){
        if(superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("super_admin_account", super_admin.getSuperAdminAccount())) !=null) {
            return R.error("用户已存在");
        }
        superAdministratorService.insert(super_admin);
        return R.ok();
    }

    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String super_admin_account, HttpServletRequest request){
        SuperAdministratorEntity super_admin = superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("super_admin_account", super_admin_account));
        if(super_admin==null) {
            return R.error("账号不存在");
        }
        super_admin.setPassword("123456");
        superAdministratorService.update(super_admin,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, SuperAdministratorEntity super_admin){
        EntityWrapper<SuperAdministratorEntity> ew = new EntityWrapper<SuperAdministratorEntity>();
        PageUtils page = superAdministratorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, super_admin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list( SuperAdministratorEntity super_admin){
        EntityWrapper<SuperAdministratorEntity> ew = new EntityWrapper<SuperAdministratorEntity>();
        ew.allEq(MPUtil.allEQMapPre( super_admin, "super_admin"));
        return R.ok().put("data", superAdministratorService.selectListView(ew));
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        SuperAdministratorEntity super_admin = superAdministratorService.selectById(id);
        return R.ok().put("data", super_admin);
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("user_id");
        SuperAdministratorEntity superAdmin = superAdministratorService.selectById(id);
        return R.ok().put("data", superAdmin);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody SuperAdministratorEntity super_admin){
        if(superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("super_admin_account", super_admin.getSuperAdminAccount())) !=null) {
            return R.error("用户已存在");
        }
        superAdministratorService.insert(super_admin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SuperAdministratorEntity super_admin){
        SuperAdministratorEntity u = superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("super_admin_account", super_admin.getSuperAdminAccount()));
        if(u!=null && u.getId()!=super_admin.getId() && u.getSuperAdminAccount().equals(super_admin.getSuperAdminAccount())) {
            return R.error("用户名已存在。");
        }
        superAdministratorService.updateById(super_admin);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        superAdministratorService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
