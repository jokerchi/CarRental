package com.controller;

import com.entity.OrdinaryAdministratorEntity;
import com.service.OrdinaryAdministratorService;
import com.service.TokenService;
import com.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrdinaryAdministratorControllerTest {

    @Autowired
    private OrdinaryAdministratorController ordinaryAdministratorController;

    @MockBean
    private OrdinaryAdministratorService ordinaryAdministratorService;

    @Test
    void login() {
        // 创建模拟的输入
        String ordinary_admin_account = "test";
        String password = "password";

        // 创建模拟的返回结果
        R expected = R.ok().put("token", "mockToken");

        // 配置模拟行为
        when(ordinaryAdministratorService.selectOne(any())).thenReturn(new OrdinaryAdministratorEntity());
        TokenService tokenService = null;
        when(tokenService.generateToken(any(), any(), any(), any())).thenReturn("mockToken");

        // 调用login方法
        R result = ordinaryAdministratorController.login(ordinary_admin_account, password, null, null);

        // 验证结果
        assertEquals(expected, result);
    }

    @Test
    void register() {
        // 创建模拟的输入
        OrdinaryAdministratorEntity ordinary_administrator = new OrdinaryAdministratorEntity();
        ordinary_administrator.setOrdinaryAdminAccount("test");

        // 创建模拟的返回结果
        R expected = R.ok();

        // 配置模拟行为
        when(ordinaryAdministratorService.selectOne(any())).thenReturn(null);

        // 调用register方法
        R result = ordinaryAdministratorController.register(ordinary_administrator);

        // 验证结果
        assertEquals(expected, result);
    }

    @Test
    void logout() {
        // 创建模拟的HttpServletRequest
        MockHttpServletRequest request = new MockHttpServletRequest();

        // 创建模拟的返回结果
        R expected = R.ok("退出成功");

        // 调用logout方法
        R result = ordinaryAdministratorController.logout(request);

        // 验证结果
        assertEquals(expected, result);
    }


    @Test
    void getCurrUser() {
    }

    @Test
    void resetPass() {
    }

    @Test
    void page() {
    }

    @Test
    void list() {
    }

    @Test
    void testList() {
    }

    @Test
    void query() {
    }

    @Test
    void info() {
    }

    @Test
    void detail() {
    }

    @Test
    void save() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void remindCount() {
    }
}