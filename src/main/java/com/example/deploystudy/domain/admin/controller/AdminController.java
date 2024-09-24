package com.example.deploystudy.domain.admin.controller;


import com.example.deploystudy.domain.admin.service.AdminService;
import com.example.deploystudy.domain.post.domain.Post;
import com.example.deploystudy.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return adminService.getUsers();
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return adminService.getPosts();
    }
}
