package com.controller;

import com.controller.ConfigController;
import com.entity.ConfigEntity;
import com.service.ConfigService;
import com.utils.R;
import com.utils.PageUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConfigControllerTest {

    @InjectMocks
    ConfigController configController;

    @Mock
    ConfigService configService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        Map<String, Object> params = new HashMap<>();
        ConfigEntity config = new ConfigEntity();

        when(configService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = configController.page(params, config);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        Map<String, Object> params = new HashMap<>();
        ConfigEntity config = new ConfigEntity();

        when(configService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = configController.list(params, config);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).queryPage(any(), any());
    }

    @Test
    public void infoReturnsCorrectData() {
        String id = "1";
        ConfigEntity config = new ConfigEntity();

        when(configService.selectById(any())).thenReturn(config);

        R result = configController.info(id);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).selectById(any());
    }

    @Test
    public void detailReturnsCorrectData() {
        String id = "1";
        ConfigEntity config = new ConfigEntity();

        when(configService.selectById(any())).thenReturn(config);

        R result = configController.detail(id);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).selectById(any());
    }

    @Test
    public void infoByNameReturnsCorrectData() {
        String name = "faceFile";
        ConfigEntity config = new ConfigEntity();

        when(configService.selectOne(any())).thenReturn(config);

        R result = configController.infoByName(name);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).selectOne(any());
    }

    @Test
    public void saveCreatesNewConfig() {
        ConfigEntity config = new ConfigEntity();

        when(configService.insert(any())).thenReturn(true);

        R result = configController.save(config);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingConfig() {
        ConfigEntity config = new ConfigEntity();

        when(configService.updateById(any())).thenReturn(true);

        R result = configController.update(config);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesConfigs() {
        Long[] ids = {1L, 2L, 3L};

        when(configService.deleteBatchIds(any())).thenReturn(true);

        R result = configController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(configService, times(1)).deleteBatchIds(any());
    }
}