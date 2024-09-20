package com.example.deploystudy.domain.user.dto.response;

import com.example.deploystudy.domain.user.domain.User;
import com.example.deploystudy.domain.user.domain.UserRole;

public record UserResponse(
        Long id,
        String username,
        UserRole role) {

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getRole());
    }
}