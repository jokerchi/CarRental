package com.controller;

import com.controller.CarInfoController;
import com.entity.CarInfoEntity;
import com.service.CarInfoService;
import com.utils.PageUtils;
import com.utils.R;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CarInfoControllerTest {

    @InjectMocks
    CarInfoController carInfoController;

    @Mock
    CarInfoService carInfoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Should return page data when page method is called")
    void shouldReturnPageDataWhenPageMethodIsCalled() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "ordinaryadministrator");
        request.getSession().setAttribute("username", "testUser");

        CarInfoEntity carInfoEntity = new CarInfoEntity();
        carInfoEntity.setOrdinaryAdminAccount("testUser");

        Map<String, Object> params = new HashMap<>();
        PageUtils pageUtils = new PageUtils();

        when(carInfoService.queryPage(any(), any())).thenReturn(pageUtils);

        R result = carInfoController.page(params, carInfoEntity, request);

        assertEquals(0, result.get("code"));
        assertEquals(pageUtils, result.get("data"));
    }

    @DisplayName("Should return list data when list method is called")
    void shouldReturnListDataWhenListMethodIsCalled() {
        CarInfoEntity carInfoEntity = new CarInfoEntity();
        Map<String, Object> params = new HashMap<>();
        PageUtils pageUtils = new PageUtils();

        when(carInfoService.queryPage(any(), any())).thenReturn(pageUtils);

        R result = carInfoController.list(params, carInfoEntity, null);

        assertEquals(0, result.get("code"));
        assertEquals(pageUtils, result.get("data"));
    }

    @DisplayName("Should return success message when save method is called")
    void shouldReturnSuccessMessageWhenSaveMethodIsCalled() {
        CarInfoEntity carInfoEntity = new CarInfoEntity();

        R result = carInfoController.save(carInfoEntity, null);

        assertEquals(0, result.get("code"));
    }
}