package org.example.carrental.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.example.carrental.annotation.IgnoreAuth;
import org.example.carrental.entity.SuperAdministratorEntity;
import org.example.carrental.service.SuperAdministratorService;
import org.example.carrental.service.TokenService;
import org.example.carrental.utils.MPUtil;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.R;
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
    public R login(String superAdminAccount, String password, String captcha, HttpServletRequest request) {
        SuperAdministratorEntity superAdmin = superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("superAdminAccount", superAdminAccount));
        if(superAdmin==null || !superAdmin.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(superAdmin.getId(),superAdminAccount, "superadministrator", superAdmin.getRole());
        return R.ok().put("token", token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SuperAdministratorEntity superAdmin){
        if(superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("superAdminAccount", superAdmin.getSuperAdminAccount())) !=null) {
            return R.error("用户已存在");
        }
        superAdministratorService.insert(superAdmin);
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
    public R resetPass(String superAdminAccount, HttpServletRequest request){
        SuperAdministratorEntity superAdmin = superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("superAdminAccount", superAdminAccount));
        if(superAdmin==null) {
            return R.error("账号不存在");
        }
        superAdmin.setPassword("123456");
        superAdministratorService.update(superAdmin,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, SuperAdministratorEntity superAdmin){
        EntityWrapper<SuperAdministratorEntity> ew = new EntityWrapper<SuperAdministratorEntity>();
        PageUtils page = superAdministratorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, superAdmin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list( SuperAdministratorEntity superAdmin){
        EntityWrapper<SuperAdministratorEntity> ew = new EntityWrapper<SuperAdministratorEntity>();
        ew.allEq(MPUtil.allEQMapPre( superAdmin, "superAdmin"));
        return R.ok().put("data", superAdministratorService.selectListView(ew));
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        SuperAdministratorEntity superAdmin = superAdministratorService.selectById(id);
        return R.ok().put("data", superAdmin);
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        SuperAdministratorEntity superAdmin = superAdministratorService.selectById(id);
        return R.ok().put("data", superAdmin);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody SuperAdministratorEntity superAdmin){
        if(superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("superAdminAccount", superAdmin.getSuperAdminAccount())) !=null) {
            return R.error("用户已存在");
        }
        superAdministratorService.insert(superAdmin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SuperAdministratorEntity superAdmin){
        SuperAdministratorEntity u = superAdministratorService.selectOne(new EntityWrapper<SuperAdministratorEntity>().eq("superAdminAccount", superAdmin.getSuperAdminAccount()));
        if(u!=null && u.getId()!=superAdmin.getId() && u.getSuperAdminAccount().equals(superAdmin.getSuperAdminAccount())) {
            return R.error("用户名已存在。");
        }
        superAdministratorService.updateById(superAdmin);//全部更新
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
