package com.example.deploystudy.global.security.jwt.dto;

public record Jwt(
        String accessToken,
        String refreshToken
) {
}
