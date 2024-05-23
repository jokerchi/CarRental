package com.controller;

import com.controller.StoreUpController;
import com.entity.StoreUpEntity;
import com.service.StoreUpService;
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

public class StoreUpControllerTest {

    @InjectMocks
    StoreUpController storeUpController;

    @Mock
    StoreUpService storeUpService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "client");
        request.getSession().setAttribute("username", "testUser");

        StoreUpEntity storeUp = new StoreUpEntity();
        Map<String, Object> params = new HashMap<>();

        when(storeUpService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = storeUpController.page(params, storeUp, request);

        assertEquals("ok", result.get("msg"));
        verify(storeUpService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        StoreUpEntity storeUp = new StoreUpEntity();
        Map<String, Object> params = new HashMap<>();

        when(storeUpService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = storeUpController.list(params, storeUp, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(storeUpService, times(1)).queryPage(any(), any());
    }

    @Test
    public void saveCreatesNewStoreUp() {
        StoreUpEntity storeUp = new StoreUpEntity();

        when(storeUpService.insert(any())).thenReturn(true);

        R result = storeUpController.save(storeUp, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(storeUpService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingStoreUp() {
        StoreUpEntity storeUp = new StoreUpEntity();

        when(storeUpService.updateById(any())).thenReturn(true);

        R result = storeUpController.update(storeUp, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(storeUpService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesStoreUps() {
        Long[] ids = {1L, 2L, 3L};

        when(storeUpService.deleteBatchIds(any())).thenReturn(true);

        R result = storeUpController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(storeUpService, times(1)).deleteBatchIds(any());
    }
}