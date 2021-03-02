package com.carepay.assignment.service;

import com.carepay.assignment.domain.Comments;
import com.carepay.assignment.domain.CommentsTO;
import com.carepay.assignment.domain.Post;
import com.carepay.assignment.exception.CommentOperationsException;
import com.carepay.assignment.exception.ExpectedValueNotFoundException;
import com.carepay.assignment.exception.InvalidPostOperationException;
import com.carepay.assignment.repository.CommentsRepository;
import com.carepay.assignment.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    PostRepository postRepository;


    /**
     * findByPostId Throw CommentOperationsException
     *
     * @param postId   ID
     * @param pageable Page
     * @return Page List of Comments
     */
    @Override
    public Page<Comments> findByPostId(Long postId, Pageable pageable) {
        try {
            return commentsRepository.findByPostId(postId, pageable);
        } catch (Exception ex) {
            log.error("Exception in finding post by id");
            throw new CommentOperationsException("Comment not found");
        }
    }

    /**
     * createComment throw InvalidPostOperationException
     * throw CommentOperationsException
     *
     * @param postId  ID
     * @param comment String Value
     * @return Comment Object
     */
    @Override
    public CommentsTO createComment(Long postId, @Valid Comments comment) {
        Comments commentResponse;

        try {
            Optional<Post> post = postRepository.findById(postId);

            if (post.isPresent()) {
                comment.setPost(post.get());
                commentResponse = commentsRepository.save(comment);
            } else {
                throw new InvalidPostOperationException("No post found to add comment");
            }
            return setCommentsTo(commentResponse);

        } catch (Exception ex) {
            log.error("Exception while createing a comment");
            throw new CommentOperationsException(ex.getMessage());
        }
    }

    /**
     * deleteComment by ID
     * throw CommentOperationsException
     *
     * @param commentId ID
     * @param postId    id of Post
     */
    @Override
    public void deleteComment(Long commentId, Long postId) {
        try {
            Optional<Comments> comment = commentsRepository.findByIdAndPostId(commentId, postId);
            if (!comment.isPresent()) {
                throw new CommentOperationsException("Comment not present");
            } else {
                commentsRepository.delete(comment.get());
            }
        } catch (Exception ex) {
            log.error("Exception in deleting comment id");
            throw new CommentOperationsException("Comment deletion unsuccessful");
        }

    }

    /**
     * getCommentDetails by ID
     *
     * @param commentId ID of Comment
     * @param postId    OD of Post
     * @return CommentsTO Object
     */
    @Override
    public CommentsTO getCommentDetails(Long commentId, Long postId) {
        Comments commentResponse;
        try {
            Optional<Comments> comment = commentsRepository.findByIdAndPostId(commentId, postId);
            if (comment.isPresent()) {
                commentResponse = comment.get();
                return setCommentsTo(commentResponse);
            } else {
                log.error("Comment with id not found");
                throw new ExpectedValueNotFoundException("Comment with id not found");
            }
        } catch (Exception ex) {
            log.error("Exception while searching Comment");
            throw new CommentOperationsException("Exception while searching Comment");
        }
    }

    /**
     * helper method to create Comment Transfer object
     *
     * @param commentsEntity Comment object
     * @return Comment object
     */
    private CommentsTO setCommentsTo(Comments commentsEntity) {
        try {
            CommentsTO commentsTO = new CommentsTO();
            commentsTO.setId(commentsEntity.getId());
            commentsTO.setPostId(commentsEntity.getPost().getId());
            commentsTO.setComment(commentsEntity.getComment());

            return commentsTO;
        } catch (Exception ex) {
            log.error("Exception thrown while mapping comments to transfer object");
            throw new CommentOperationsException("Comment cannot be updated");
        }
    }

}
