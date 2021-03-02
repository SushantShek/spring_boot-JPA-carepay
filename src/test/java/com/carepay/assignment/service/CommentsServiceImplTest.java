/*
package com.carepay.assignment.service;

import com.carepay.assignment.domain.Comments;
import com.carepay.assignment.domain.CommentsTO;
import com.carepay.assignment.domain.Post;
import com.carepay.assignment.exception.CommentOperationsException;
import com.carepay.assignment.exception.InvalidPostOperationException;
import com.carepay.assignment.repository.CommentsRepository;
import com.carepay.assignment.repository.PostRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CommentsServiceImplTest {

    @Mock
    CommentsRepository commentsRepository;
    @Mock
    PostRepository postRepository;

    @Autowired
    CommentsServiceImpl commentsService;

    private Comments comments;
    private Post post;

    @BeforeEach
    void setUp() {
        comments = new Comments();
        post = new Post();
    }

    @Test
    @Ignore
    void findByPostId() {
        comments.setComment("test comment");
        comments.setId(1L);
        List<Comments> listComment = new ArrayList<>();
        listComment.add(comments);
        Pageable pageable = PageRequest.of(0, 8);
        Page<Comments> comment = new PageImpl<>(listComment, pageable, pageable.getPageSize());

        when(commentsRepository.findByPostId(anyLong(), any())).thenReturn(comment);
        Page<Comments> response = commentsService.findByPostId(1L, pageable);
        assertNotNull(response);
    }

    @Test
    @Ignore
    void createComment() {
        post.setContent("Test content");
        post.setTitle("Test");
        post.setId(1L);

        comments.setComment("test comment");
        comments.setId(1L);
        CommentsTO comment = new CommentsTO(1L, "test comment", 1L);

        when(postRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(post));
        when(commentsRepository.save(any())).thenReturn(comment);

        CommentsTO response = commentsService.createComment(1L, comments);
        assertNotNull(response);
        assertEquals("test comment", response.getComment());
    }

    @Test
    @Ignore
    void createComment_for_invalid_throw_exception() {

        comments.setComment("qwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdf");
        comments.setId(1L);
        assertThrows(InvalidPostOperationException.class, () -> commentsService.createComment(1L, comments));
    }

    @Test
    @Ignore
    void deleteComment_for_no_post_return_exception() {

        when(commentsRepository.findByIdAndPostId(anyLong(), anyLong())).thenReturn(java.util.Optional.ofNullable(null));
        assertThrows(CommentOperationsException.class, () -> commentsService.deleteComment(1L, 1L));

    }

    @Test
    @Ignore
    void getCommentDetails() {

        Set<Comments> setOfComments = new HashSet<>();
        setOfComments.add(comments);
        post.setContent("Test content");
        post.setTitle("Test");
        post.setId(1L);
        post.setComments(setOfComments);

        comments.setComment("test comment");
        comments.setId(1L);
        comments.setPost(post);
        Optional<Comments> optionalComment = Optional.of(comments);

        when(commentsRepository.findByIdAndPostId(anyLong(), anyLong())).thenReturn(optionalComment);
        CommentsTO response = commentsService.getCommentDetails(1L, 1L);
        assertNotNull(comments);
    }

}*/
