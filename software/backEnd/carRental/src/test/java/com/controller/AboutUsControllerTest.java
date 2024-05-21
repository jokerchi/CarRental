package com.controller;

import com.entity.AboutUsEntity;
import com.service.AboutUsService;
import com.utils.PageUtils;
import com.utils.R;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AboutUsControllerTest {

    private MockMvc mockMvc;
    @Mock
    private AboutUsService aboutUsService;
    @InjectMocks
    private AboutUsController aboutUsController;
    @Test
    void page() {
        Map<String, Object> params = new HashMap<>();
        params.put("page", "1");
        params.put("limit", "10");
        PageUtils pageUtils = new PageUtils(null, 0, 10, 1);

        when(aboutUsService.queryPage(params, null)).thenReturn(pageUtils);

    }

    @Test
    void testPage() {
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