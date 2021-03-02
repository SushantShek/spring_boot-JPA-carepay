package com.carepay.assignment.service;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.Post;
import com.carepay.assignment.domain.PostDetails;
import com.carepay.assignment.domain.PostInfo;
import com.carepay.assignment.exception.CommentOperationsException;
import com.carepay.assignment.exception.InvalidPostOperationException;
import com.carepay.assignment.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostDetails postDetails;

    /**
     * createPost method
     * takes CreatePostRequest object
     * throw InvalidPostOperationException
     *
     * @param createPostRequest service
     * @return PostDetails object
     */
    @Override
    public PostDetails createPost(@Valid CreatePostRequest createPostRequest) {
        try {
            Post post = new Post();
            post.setTitle(createPostRequest.getTitle());
            post.setContent(createPostRequest.getContent());
            Post postResponse = postRepository.save(post);
            postDetails.setId(postResponse.getId());
            postDetails.setTitle(postResponse.getTitle());
            postDetails.setContent(postResponse.getContent());

        } catch (Exception e) {
            log.error("Exception while creating post" + e);
            throw new InvalidPostOperationException("Exception while creating post");
        }
        return postDetails;
    }

    /**
     * getPosts takes Pageable
     * throw InvalidPostOperationException
     *
     * @param pageable List
     * @return Page List PostInfo
     */
    @Override
    public Page<PostInfo> getPosts(Pageable pageable) {
        try {
            Page<Post> pagedResult = postRepository.findAll(pageable);
            List<PostInfo> postInfoList = new ArrayList<PostInfo>();
            pagedResult.forEach(data -> {
                PostInfo postInfo = new PostInfo();
                postInfo.setId(data.getId());
                postInfo.setTitle(data.getTitle());
                postInfoList.add(postInfo);
            });
            return (pagedResult.hasContent())
                    ? new PageImpl(postInfoList, pagedResult.getPageable(), pagedResult.getTotalElements())
                    : new PageImpl(new ArrayList<>(), pagedResult.getPageable(), pagedResult.getTotalElements());
        } catch (Exception e) {
            log.error("Exception in getPosts ");
            throw new InvalidPostOperationException("Exception in getPosts");
        }
    }

    /**
     * getPostDetails takes ID
     * throw CommentOperationsException
     * @param id post ID
     * @return PostDetails object
     */
    @Override
    public PostDetails getPostDetails(Long id) {
        try {
            Optional<Post> optionalPost = postRepository.findById(id);
            if (optionalPost.isPresent()) {
                postDetails.setContent(optionalPost.get().getContent());
                postDetails.setId(optionalPost.get().getId());
                postDetails.setTitle(optionalPost.get().getTitle());
                return postDetails;
            } else {
                log.error("PostDetails is not present for ID " + postDetails.getId());
                throw new InvalidPostOperationException("PostDetails is not present for ID ");
            }
        } catch (Exception e) {
            log.error("Get Post details exception " + e);
            throw new CommentOperationsException("Get Post details exception ");
        }
    }

    /**
     * deletePost takes ID
     * Throw CommentOperationsException
     * @param id post ID
     */
    @Override
    public void deletePost(Long id) {
        try {
            if (id != null)
                postRepository.deleteById(id);
            else
                throw new NullPointerException();
        } catch (Exception e) {
            log.error("Exception while deleting post");
            throw new CommentOperationsException("Exception while deleting post");
        }
    }
}
