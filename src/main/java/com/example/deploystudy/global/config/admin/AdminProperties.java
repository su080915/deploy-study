package com.example.deploystudy.global.config.admin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "admin")
public class AdminProperties {
    private final String username;
    private final String password;
}
