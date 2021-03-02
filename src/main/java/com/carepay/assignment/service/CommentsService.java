package com.carepay.assignment.service;

import com.carepay.assignment.domain.Comments;
import com.carepay.assignment.domain.CommentsTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

public interface CommentsService {

    /**
     * To find the Post by Post ID
     * @param postId ID
     * @param pageable Page
     * @return Page list of Comments
     */
    Page<Comments> findByPostId(Long postId, Pageable pageable);

    /**
     * Create new Comment
     * @param postId ID
     * @param comment String Value
     * @return Comment transfer Object
     */
    CommentsTO createComment(Long postId, @Valid Comments comment);

    /**
     * Delete a comment by its ID
     * @param commentId ID
     * @param postId id of Post
     */
    void deleteComment(Long commentId, Long postId);

    /**
     * Get Comments from ids
     * @param commentId ID of Comment
     * @param postId OD of Post
     * @return Comment transfer Object
     */
    CommentsTO getCommentDetails(Long commentId, Long postId);

}
