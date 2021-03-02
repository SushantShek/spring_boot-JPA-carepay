package com.carepay.assignment.web;

import com.carepay.assignment.domain.Comments;
import com.carepay.assignment.domain.CommentsTO;
import com.carepay.assignment.service.CommentsService;
import com.carepay.assignment.service.CommentsServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentsController {
    private final CommentsService commentsService;

    public CommentsController(CommentsServiceImpl commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/{postId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public Page<Comments> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId, Pageable pageable) {
        return commentsService.findByPostId(postId, pageable);
    }

    @PostMapping("/{postId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentsTO createComment(@PathVariable(value = "postId") Long postId,
                                    @RequestBody @Valid Comments comment) {
        return commentsService.createComment(postId, comment);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") Long postId,
                                           @PathVariable(value = "commentId") Long commentId) {
        commentsService.deleteComment(commentId, postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentsTO getCommentDetails(@PathVariable(value = "postId") Long postId,
                                        @PathVariable(value = "commentId") Long commentId) {
        return commentsService.getCommentDetails(commentId, postId);
    }

}
