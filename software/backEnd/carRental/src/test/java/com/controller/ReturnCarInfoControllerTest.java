package com.controller;

import com.controller.ReturnCarInfoController;
import com.entity.ReturnCarInfoEntity;
import com.service.ReturnCarInfoService;
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

public class ReturnCarInfoControllerTest {

    @InjectMocks
    ReturnCarInfoController returnCarInfoController;

    @Mock
    ReturnCarInfoService returnCarInfoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "client");

        ReturnCarInfoEntity returnCarInfo = new ReturnCarInfoEntity();
        Map<String, Object> params = new HashMap<>();

        when(returnCarInfoService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = returnCarInfoController.page(params, returnCarInfo, request);

        assertEquals("ok", result.get("msg"));
        verify(returnCarInfoService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "client");

        ReturnCarInfoEntity returnCarInfo = new ReturnCarInfoEntity();
        Map<String, Object> params = new HashMap<>();

        when(returnCarInfoService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = returnCarInfoController.list(params, returnCarInfo, request);

        assertEquals("ok", result.get("msg"));
        verify(returnCarInfoService, times(1)).queryPage(any(), any());
    }

    @Test
    public void saveCreatesNewReturnCarInfo() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("userId", 1L);

        ReturnCarInfoEntity returnCarInfo = new ReturnCarInfoEntity();

        when(returnCarInfoService.insert(any())).thenReturn(true);

        R result = returnCarInfoController.save(returnCarInfo, request);

        assertEquals("ok", result.get("msg"));
        verify(returnCarInfoService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingReturnCarInfo() {
        ReturnCarInfoEntity returnCarInfo = new ReturnCarInfoEntity();

        when(returnCarInfoService.updateById(any())).thenReturn(true);

        R result = returnCarInfoController.update(returnCarInfo);

        assertEquals("ok", result.get("msg"));
        verify(returnCarInfoService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesReturnCarInfos() {
        Long[] ids = {1L, 2L, 3L};

        when(returnCarInfoService.deleteBatchIds(any())).thenReturn(true);

        R result = returnCarInfoController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(returnCarInfoService, times(1)).deleteBatchIds(any());
    }
}