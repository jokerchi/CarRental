package com.controller;

import com.controller.CancelOrderController;
import com.entity.CancelOrderEntity;
import com.service.CancelOrderService;
import com.utils.PageUtils;
import com.utils.R;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CancelOrderControllerTest {

    @InjectMocks
    CancelOrderController cancelOrderController;

    @Mock
    CancelOrderService cancelOrderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return page data when page method is called")
    public void shouldReturnPageDataWhenPageMethodIsCalled() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "client");
        request.getSession().setAttribute("username", "testUser");

        CancelOrderEntity cancelOrderEntity = new CancelOrderEntity();
        cancelOrderEntity.setClientAccount("testUser");

        Map<String, Object> params = new HashMap<>();
        PageUtils pageUtils = new PageUtils();

        when(cancelOrderService.queryPage(any(), any())).thenReturn(pageUtils);

        R result = cancelOrderController.page(params, cancelOrderEntity, request);

        assertEquals(0, result.get("code"));
        assertEquals(pageUtils, result.get("data"));
    }

    @Test
    @DisplayName("Should return list data when list method is called")
    public void shouldReturnListDataWhenListMethodIsCalled() {
        CancelOrderEntity cancelOrderEntity = new CancelOrderEntity();
        Map<String, Object> params = new HashMap<>();
        PageUtils pageUtils = new PageUtils();

        when(cancelOrderService.queryPage(any(), any())).thenReturn(pageUtils);

        R result = cancelOrderController.list(params, cancelOrderEntity, null);

        assertEquals(0, result.get("code"));
        assertEquals(pageUtils, result.get("data"));
    }

    @Test
    @DisplayName("Should return success message when save method is called")
    public void shouldReturnSuccessMessageWhenSaveMethodIsCalled() {
        CancelOrderEntity cancelOrderEntity = new CancelOrderEntity();

        R result = cancelOrderController.save(cancelOrderEntity, null);

        assertEquals(0, result.get("code"));
    }
}