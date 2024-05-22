package com.controller;

import com.controller.ClientController;
import com.entity.ClientEntity;
import com.service.ClientService;
import com.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientControllerTest {

    @Autowired
    private ClientController clientController;

    @MockBean
    private ClientService clientService;

    @Test
    public void testLogin() {
        // 创建一个模拟的HttpServletRequest
        MockHttpServletRequest request = new MockHttpServletRequest();

        // 创建一个模拟的ClientEntity
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(1L);
        clientEntity.setAccount("账号1");
        clientEntity.setPassword("123456");

        // 当clientService.selectOne被调用时，返回模拟的ClientEntity
        when(clientService.selectOne(any())).thenReturn(clientEntity);

        // 调用login方法
        R result = clientController.login("账号1", "123456", "test", request);

        // 验证结果
        assertEquals(0, result.get("code"));
        assertNotNull(result.get("token"));
    }
}