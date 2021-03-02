package com.carepay.assignment.repository;

import com.carepay.assignment.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for all Post related Operations
 * from the Database
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
