package com.carepay.assignment.repository;

import com.carepay.assignment.domain.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository class for all Comments
 * and related Database operations
 */
@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    /**
     * Custom get comments by post id from
     * @param postId ID of the Post
     * @param pageable return page
     * @return Page List of Comments
     */
    Page<Comments> findByPostId(Long postId, Pageable pageable);

    /**
     * Find comments by comment and post ID
     * @param id Comment ID
     * @param postId Post ID
     * @return Optional Comment object
     */
    Optional<Comments> findByIdAndPostId(Long id, Long postId);
}