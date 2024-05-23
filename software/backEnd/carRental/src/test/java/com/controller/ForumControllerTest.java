package com.controller;

import com.controller.ForumController;
import com.entity.ForumEntity;
import com.service.ForumService;
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

public class ForumControllerTest {

    @InjectMocks
    ForumController forumController;

    @Mock
    ForumService forumService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pageReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("role", "管理员");

        ForumEntity forum = new ForumEntity();
        Map<String, Object> params = new HashMap<>();

        when(forumService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = forumController.page(params, forum, request);

        assertEquals("ok", result.get("msg"));
        verify(forumService, times(1)).queryPage(any(), any());
    }

    @Test
    public void listReturnsCorrectData() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("role", "管理员");

        ForumEntity forum = new ForumEntity();
        Map<String, Object> params = new HashMap<>();

        when(forumService.queryPage(any(), any())).thenReturn(new PageUtils());

        R result = forumController.list(params, forum, request);

        assertEquals("ok", result.get("msg"));
        verify(forumService, times(1)).queryPage(any(), any());
    }

    @Test
    public void saveCreatesNewForum() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("userId", 1L);

        ForumEntity forum = new ForumEntity();

        when(forumService.insert(any())).thenReturn(true);

        R result = forumController.save(forum, request);

        assertEquals("ok", result.get("msg"));
        verify(forumService, times(1)).insert(any());
    }

    @Test
    public void updateModifiesExistingForum() {
        ForumEntity forum = new ForumEntity();

        when(forumService.updateById(any())).thenReturn(true);

        R result = forumController.update(forum);

        assertEquals("ok", result.get("msg"));
        verify(forumService, times(1)).updateById(any());
    }

    @Test
    public void deleteRemovesForums() {
        Long[] ids = {1L, 2L, 3L};

        when(forumService.deleteBatchIds(any())).thenReturn(true);

        R result = forumController.delete(ids);

        assertEquals("ok", result.get("msg"));
        verify(forumService, times(1)).deleteBatchIds(any());
    }
}