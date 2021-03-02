package com.carepay.assignment.service;

import javax.validation.Valid;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.PostDetails;
import com.carepay.assignment.domain.PostInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    /**
     * createPost Interface
     * @param createPostRequest service
     * @return PostDetails
     */
    PostDetails createPost(@Valid CreatePostRequest createPostRequest);

    /**
     * getPosts Interface
     * @param pageable List
     * @return Page List of PostInfo
     */
    Page<PostInfo> getPosts(final Pageable pageable);

    /**
     * getPostDetails interface
     * @param id post ID
     * @return PostDetail Object
     */
    PostDetails getPostDetails(Long id);

    /**
     * deletePost interface
     * @param id post ID
     */
    void deletePost(Long id);
}
