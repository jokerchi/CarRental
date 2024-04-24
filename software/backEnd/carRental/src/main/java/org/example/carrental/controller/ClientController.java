package org.example.carrental.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.example.carrental.annotation.IgnoreAuth;
import org.example.carrental.entity.ClientEntity;
import org.example.carrental.entity.view.ClientView;
import org.example.carrental.service.ClientService;
import org.example.carrental.service.TokenService;
import org.example.carrental.utils.MPUtil;
import org.example.carrental.utils.PageUtils;
import org.example.carrental.utils.R;
import org.example.carrental.utils.ValidatorUtils;
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
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;



    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(@RequestParam("username") String account, String password, String captcha, HttpServletRequest request) {
        System.out.println("account: "+account+" password: "+password);

        ClientEntity u = clientService.selectOne(new EntityWrapper<ClientEntity>().eq("account", account));
        if(u==null || !u.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }

        String token = tokenService.generateToken(u.getId(), account,"client",  "用户" );
        return R.ok().put("token", token);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ClientEntity client){
        ValidatorUtils.validateEntity(client);
        ClientEntity u = clientService.selectOne(new EntityWrapper<ClientEntity>().eq("account", client.getAccount()));
        if(u!=null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        client.setId(uId);
        clientService.insert(client);
        return R.ok();
    }


    /**
     * 退出
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        ClientEntity u = clientService.selectById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String account, HttpServletRequest request){
        ClientEntity u = clientService.selectOne(new EntityWrapper<ClientEntity>().eq("account", account));
        if(u==null) {
            return R.error("账号不存在");
        }
        u.setPassword("123456");
        clientService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ClientEntity client,
                  HttpServletRequest request){
        EntityWrapper<ClientEntity> ew = new EntityWrapper<ClientEntity>();

        PageUtils page = clientService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, client), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ClientEntity client,
                  HttpServletRequest request){
        EntityWrapper<ClientEntity> ew = new EntityWrapper<ClientEntity>();

        PageUtils page = clientService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, client), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ClientEntity client){
        EntityWrapper<ClientEntity> ew = new EntityWrapper<ClientEntity>();
        ew.allEq(MPUtil.allEQMapPre( client, "client"));
        return R.ok().put("data", clientService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ClientEntity client){
        EntityWrapper<ClientEntity> ew = new EntityWrapper<ClientEntity>();
        ew.allEq(MPUtil.allEQMapPre( client, "client"));
        ClientView clientView =  clientService.selectView(ew);
        return R.ok("查询用户成功").put("data", clientView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ClientEntity client = clientService.selectById(id);
        return R.ok().put("data", client);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ClientEntity client = clientService.selectById(id);
        return R.ok().put("data", client);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ClientEntity client, HttpServletRequest request){
        client.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        ClientEntity u = clientService.selectOne(new EntityWrapper<ClientEntity>().eq("account", client.getAccount()));
        if(u!=null) {
            return R.error("用户已存在");
        }
        client.setId(new Date().getTime());
        clientService.insert(client);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ClientEntity client, HttpServletRequest request){
        client.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        ClientEntity u = clientService.selectOne(new EntityWrapper<ClientEntity>().eq("account", client.getAccount()));
        if(u!=null) {
            return R.error("用户已存在");
        }
        client.setId(new Date().getTime());
        clientService.insert(client);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ClientEntity client, HttpServletRequest request){
        clientService.updateById(client);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        clientService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<ClientEntity> wrapper = new EntityWrapper<ClientEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }


        int count = clientService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
