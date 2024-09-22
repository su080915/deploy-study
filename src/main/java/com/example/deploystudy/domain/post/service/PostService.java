package com.example.deploystudy.domain.post.service;


import com.example.deploystudy.domain.post.domain.Post;
import com.example.deploystudy.domain.post.dto.request.PostCreateRequest;
import com.example.deploystudy.domain.post.dto.request.PostUpdateRequest;
import com.example.deploystudy.domain.post.dto.response.PostResponse;
import com.example.deploystudy.domain.post.error.PostError;
import com.example.deploystudy.domain.post.repository.PostRepository;
import com.example.deploystudy.domain.user.domain.User;
import com.example.deploystudy.global.exception.CustomException;
import com.example.deploystudy.global.security.session.UserSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserSession userSession;

    @Transactional
    public void createPost(PostCreateRequest request) {
        User user = userSession.getUser();
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(user)
                .viewCount(0L).build();
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public PostResponse getPost(Long id) {
        User user = userSession.getUser();
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(PostError.POST_NOT_FOUND));
        post.setViewCount(post.getViewCount()+1);
        post = postRepository.save(post);

        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .author(user)
                .viewCount(post.getViewCount())
                .build();
    }

    @Transactional
    public void updatePost(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(PostError.POST_NOT_FOUND));
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new CustomException(PostError.POST_NOT_FOUND));
        postRepository.delete(post);
    }
}
