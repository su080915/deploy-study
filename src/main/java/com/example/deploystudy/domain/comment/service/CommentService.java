package com.example.deploystudy.domain.comment.service;


import com.example.deploystudy.domain.comment.domain.Comment;
import com.example.deploystudy.domain.comment.dto.request.CommentCreateRequest;
import com.example.deploystudy.domain.comment.repository.CommentRepository;
import com.example.deploystudy.domain.post.domain.Post;
import com.example.deploystudy.domain.post.error.PostError;
import com.example.deploystudy.domain.post.repository.PostRepository;
import com.example.deploystudy.domain.user.domain.User;
import com.example.deploystudy.global.exception.CustomException;
import com.example.deploystudy.global.security.session.UserSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserSession userSession;
    private final PostRepository postRepository;

    @Transactional
    public void createComment(CommentCreateRequest request) {
        User user = userSession.getUser();
        Post post = postRepository.findById(request.postId()).orElseThrow(() -> new CustomException(PostError.POST_NOT_FOUND));
        Comment comment = Comment.builder()
                .author(user)
                .text(request.text())
                .post(post)
                .build();
         commentRepository.save(comment);
    }

    @Transactional
    public List<Comment> getComments(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(PostError.POST_NOT_FOUND));
        return commentRepository.findAllByPost(post);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
