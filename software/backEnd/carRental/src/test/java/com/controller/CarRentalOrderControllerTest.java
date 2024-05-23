package com.controller;

import com.controller.CarRentalOrderController;
import com.entity.CarRentalOrderEntity;
import com.service.CarRentalOrderService;
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

public class CarRentalOrderControllerTest {

    @InjectMocks
    CarRentalOrderController carRentalOrderController;

    @Mock
    CarRentalOrderService carRentalOrderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("tableName", "client");
        request.getSession().setAttribute("username", "testUser");

        CarRentalOrderEntity carRentalOrder = new CarRentalOrderEntity();
        Map<String, Object> params = new HashMap<>();

        when(carRentalOrderService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = carRentalOrderController.page(params, carRentalOrder, request);

        assertEquals("ok", result.get("msg"));
        verify(carRentalOrderService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        CarRentalOrderEntity carRentalOrder = new CarRentalOrderEntity();
        Map<String, Object> params = new HashMap<>();

        when(carRentalOrderService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = carRentalOrderController.list(params, carRentalOrder, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(carRentalOrderService, times(1)).queryPage(any(), any());
    }

    @Test
    public void saveCreatesNewOrder() {
        CarRentalOrderEntity carRentalOrder = new CarRentalOrderEntity();

        when(carRentalOrderService.insert(any())).thenReturn(true);

        R result = carRentalOrderController.save(carRentalOrder, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(carRentalOrderService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingOrder() {
        CarRentalOrderEntity carRentalOrder = new CarRentalOrderEntity();

        when(carRentalOrderService.updateById(any())).thenReturn(true);

        R result = carRentalOrderController.update(carRentalOrder, new MockHttpServletRequest());

        assertEquals("ok", result.get("msg"));
        verify(carRentalOrderService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesOrders() {
        Long[] ids = {1L, 2L, 3L};

        when(carRentalOrderService.deleteBatchIds(any())).thenReturn(true);

        R result = carRentalOrderController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(carRentalOrderService, times(1)).deleteBatchIds(any());
    }
}