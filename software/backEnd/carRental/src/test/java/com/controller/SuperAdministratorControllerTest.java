package com.controller;

import com.controller.SuperAdministratorController;
import com.entity.SuperAdministratorEntity;
import com.service.SuperAdministratorService;
import com.service.TokenService;
import com.utils.R;
import com.utils.PageUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SuperAdministratorControllerTest {

    @InjectMocks
    SuperAdministratorController superAdministratorController;

    @Mock
    SuperAdministratorService superAdministratorService;

    @Mock
    TokenService tokenService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "client");
        request.getSession().setAttribute("username", "testUser");

        SuperAdministratorEntity superAdmin = new SuperAdministratorEntity();
        Map<String, Object> params = new HashMap<>();

        when(superAdministratorService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = superAdministratorController.page(params, superAdmin, request);

        assertEquals("ok", result.get("msg"));
        verify(superAdministratorService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        SuperAdministratorEntity superAdmin = new SuperAdministratorEntity();
        Map<String, Object> params = new HashMap<>();

        when(superAdministratorService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = superAdministratorController.list(params, superAdmin, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(superAdministratorService, times(1)).queryPage(any(), any());
    }

    @Test
    public void saveCreatesNewSuperAdmin() {
        SuperAdministratorEntity superAdmin = new SuperAdministratorEntity();

        when(superAdministratorService.insert(any())).thenReturn(true);

        R result = superAdministratorController.save(superAdmin, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(superAdministratorService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingSuperAdmin() {
        SuperAdministratorEntity superAdmin = new SuperAdministratorEntity();

        when(superAdministratorService.updateById(any())).thenReturn(true);

        R result = superAdministratorController.update(superAdmin, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(superAdministratorService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesSuperAdmins() {
        Long[] ids = {1L, 2L, 3L};

        when(superAdministratorService.deleteBatchIds(any())).thenReturn(true);

        R result = superAdministratorController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(superAdministratorService, times(1)).deleteBatchIds(any());
    }
}