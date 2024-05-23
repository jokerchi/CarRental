package com.controller;

import com.entity.AboutUsEntity;
import com.service.AboutUsService;
import com.utils.PageUtils;
import com.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AboutUsControllerTest {

    @Autowired
    private AboutUsController aboutUsController;

    @MockBean
    private AboutUsService aboutUsService;

    @Test
    public void testPage() {
        // 创建一个模拟的HttpServletRequest
        MockHttpServletRequest request = new MockHttpServletRequest();

        // 创建一个模拟的AboutUsEntity
        AboutUsEntity aboutUsEntity = new AboutUsEntity();

        // 创建一个模拟的参数Map
        Map<String, Object> params = new HashMap<>();

        // 创建一个模拟的PageUtils
        PageUtils pageUtils = new PageUtils();

        // 当aboutUsService.queryPage被调用时，返回模拟的PageUtils
        when(aboutUsService.queryPage(any(), any())).thenReturn(pageUtils);

        // 调用page方法
        R result = aboutUsController.page(params, aboutUsEntity, request);

        // 验证结果
        assertEquals(0, result.get("code"));
        assertEquals(pageUtils, result.get("data"));
    }
}