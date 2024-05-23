package com.controller;

import com.controller.ExcitingActivitiesController;
import com.entity.ExcitingActivitiesEntity;
import com.service.ExcitingActivitiesService;
import com.utils.R;
import com.utils.PageUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExcitingActivitiesControllerTest {

    @InjectMocks
    ExcitingActivitiesController excitingActivitiesController;

    @Mock
    ExcitingActivitiesService excitingActivitiesService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        Map<String, Object> params = new HashMap<>();
        ExcitingActivitiesEntity excitingActivities = new ExcitingActivitiesEntity();

        when(excitingActivitiesService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = excitingActivitiesController.page(params, excitingActivities);

        assertEquals("ok", result.get("msg"));
        verify(excitingActivitiesService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        Map<String, Object> params = new HashMap<>();
        ExcitingActivitiesEntity excitingActivities = new ExcitingActivitiesEntity();

        when(excitingActivitiesService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = excitingActivitiesController.list(params, excitingActivities);

        assertEquals("ok", result.get("msg"));
        verify(excitingActivitiesService, times(1)).queryPage(any(), any());
    }

    @Test
    public void saveCreatesNewActivity() {
        ExcitingActivitiesEntity excitingActivities = new ExcitingActivitiesEntity();

        when(excitingActivitiesService.insert(any())).thenReturn(true);

        R result = excitingActivitiesController.save(excitingActivities);

        assertEquals("ok", result.get("msg"));
        verify(excitingActivitiesService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingActivity() {
        ExcitingActivitiesEntity excitingActivities = new ExcitingActivitiesEntity();

        when(excitingActivitiesService.updateById(any())).thenReturn(true);

        R result = excitingActivitiesController.update(excitingActivities);

        assertEquals("ok", result.get("msg"));
        verify(excitingActivitiesService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesActivities() {
        Long[] ids = {1L, 2L, 3L};

        when(excitingActivitiesService.deleteBatchIds(any())).thenReturn(true);

        R result = excitingActivitiesController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(excitingActivitiesService, times(1)).deleteBatchIds(any());
    }
}