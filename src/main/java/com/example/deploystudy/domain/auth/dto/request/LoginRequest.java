package com.example.deploystudy.domain.auth.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
