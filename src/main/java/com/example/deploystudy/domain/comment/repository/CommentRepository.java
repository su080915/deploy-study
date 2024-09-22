package com.example.deploystudy.domain.comment.repository;

import com.example.deploystudy.domain.comment.domain.Comment;
import com.example.deploystudy.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
}
