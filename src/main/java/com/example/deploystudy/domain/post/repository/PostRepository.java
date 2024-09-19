package com.example.deploystudy.domain.post.repository;

import com.example.deploystudy.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
