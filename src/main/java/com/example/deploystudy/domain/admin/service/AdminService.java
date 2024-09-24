package com.example.deploystudy.domain.admin.service;


import com.example.deploystudy.domain.post.domain.Post;
import com.example.deploystudy.domain.post.repository.PostRepository;
import com.example.deploystudy.domain.user.domain.User;
import com.example.deploystudy.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
