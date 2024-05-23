package com.controller;

import com.controller.CommonController;
import com.service.CommonService;
import com.service.ConfigService;
import com.utils.R;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CommonControllerTest {

    @InjectMocks
    CommonController commonController;

    @Mock
    CommonService commonService;

    @Mock
    ConfigService configService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getOptionReturnsCorrectData() {
        String tableName = "client";
        String columnName = "testUser";
        String conditionColumn = "conditionColumn";
        String conditionValue = "conditionValue";
        String level = "level";
        String parent = "parent";

        when(commonService.getOption(any())).thenReturn(new ArrayList<>());

        R result = commonController.getOption(tableName, columnName, conditionColumn, conditionValue, level, parent);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).getOption(any());
    }

    @Test
    public void getFollowByOptionReturnsCorrectData() {
        String tableName = "client";
        String columnName = "testUser";
        String columnValue = "columnValue";

        when(commonService.getFollowByOption(any())).thenReturn(new HashMap<>());

        R result = commonController.getFollowByOption(tableName, columnName, columnValue);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).getFollowByOption(any());
    }

    @Test
    public void shReturnsCorrectData() {
        String tableName = "client";
        Map<String, Object> map = new HashMap<>();

        doNothing().when(commonService).sh(any());

        R result = commonController.sh(tableName, map);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).sh(any());
    }

    @Test
    public void remindCountReturnsCorrectData() {
        String tableName = "client";
        String columnName = "testUser";
        String type = "1";
        Map<String, Object> map = new HashMap<>();

        when(commonService.remindCount(any())).thenReturn(1);

        R result = commonController.remindCount(tableName, columnName, type, map);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).remindCount(any());
    }

    @Test
    public void calReturnsCorrectData() {
        String tableName = "client";
        String columnName = "testUser";

        when(commonService.selectCal(any())).thenReturn(new HashMap<>());

        R result = commonController.cal(tableName, columnName);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).selectCal(any());
    }

    @Test
    public void groupReturnsCorrectData() {
        String tableName = "client";
        String columnName = "testUser";

        when(commonService.selectGroup(any())).thenReturn(new ArrayList<>());

        R result = commonController.group(tableName, columnName);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).selectGroup(any());
    }

    @Test
    public void valueReturnsCorrectData() {
        String tableName = "client";
        String xColumnName = "xColumnName";
        String yColumnName = "yColumnName";

        when(commonService.selectValue(any())).thenReturn(new ArrayList<>());

        R result = commonController.value(tableName, xColumnName, yColumnName);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).selectValue(any());
    }

    @Test
    public void valueDayReturnsCorrectData() {
        String tableName = "client";
        String xColumnName = "xColumnName";
        String yColumnName = "yColumnName";
        String timeStatType = "timeStatType";

        when(commonService.selectTimeStatValue(any())).thenReturn(new ArrayList<>());

        R result = commonController.valueDay(tableName, xColumnName, yColumnName, timeStatType);

        assertEquals("ok", result.get("msg"));
        verify(commonService, times(1)).selectTimeStatValue(any());
    }
}