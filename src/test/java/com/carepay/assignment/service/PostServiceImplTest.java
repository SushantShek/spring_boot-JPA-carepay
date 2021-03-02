/*
package com.carepay.assignment.service;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.Post;
import com.carepay.assignment.domain.PostDetails;
import com.carepay.assignment.domain.PostInfo;
import com.carepay.assignment.exception.CommentOperationsException;
import com.carepay.assignment.exception.InvalidPostOperationException;
import com.carepay.assignment.repository.PostRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PostServiceImplTest {

    private final String TITLE = " Test";
    private final String CONTENT = " Content to test";
    @InjectMocks
    PostServiceImpl postService;
    @MockBean
    PostRepository postRepository;

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
    }

    @Test
    @Ignore
    void createPost_with_valid_object() {
        CreatePostRequest request = new CreatePostRequest(TITLE, CONTENT);
        post.setId(1L);
        post.setTitle(TITLE);
        post.setContent(CONTENT);

        when(postRepository.save(any())).thenReturn(post);
        PostDetails response = postService.createPost(request);
        assertNotNull(response);
        assertEquals(TITLE, response.getTitle());

    }

    @Test
    @Ignore
    void createPost_with_invalid_object() {

        assertThrows(InvalidPostOperationException.class, () -> postService.createPost(null));
    }

    @Test
    @Ignore
    void getPosts_all_post() {
        post.setId(1L);
        post.setTitle(TITLE);
        post.setContent(CONTENT);

        Pageable pageable = PageRequest.of(0, 8);

        List<Post> listPost = new ArrayList<>();
        listPost.add(post);
        Page<Post> post = new PageImpl<>(listPost, pageable, pageable.getPageSize());
        when(postRepository.findAll(pageable)).thenReturn(post);
        Page<PostInfo> response = postService.getPosts(pageable);
        assertNotNull(response);
        Optional<PostInfo> obj = response.get().findAny();
        PostInfo resp =  obj.get();
        assertEquals(TITLE, resp.getTitle());

    }

    @Test
    @Ignore
    void getPosts_all_post_for_null_pageable() {
        assertThrows(InvalidPostOperationException.class, () -> postService.getPosts(null));
    }


    @Test
    @Ignore
    void getPostDetails_find_detail_for_id() {

        post.setId(1L);
        post.setTitle(TITLE);
        post.setContent(CONTENT);
        Optional<Post> optionalPost = Optional.ofNullable(post);

        when(postRepository.findById(anyLong())).thenReturn(optionalPost);
        PostDetails details = postService.getPostDetails(1L);
        assertEquals(CONTENT, details.getContent());
    }

    @Test
    @Ignore
    void getPostDetails_find_detail_for_id_null() {
        assertThrows(CommentOperationsException.class, () -> postService.getPostDetails(null));
    }

    @Test
    @Ignore
    void deletePost_for_null_input() {
        assertThrows(CommentOperationsException.class, () -> postService.deletePost(null));
    }
}*/
