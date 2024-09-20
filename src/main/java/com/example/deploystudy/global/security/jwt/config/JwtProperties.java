package com.example.deploystudy.global.security.jwt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "jwt") // yml 값과 연결
public class JwtProperties {
    private String secretKey;
    private long accessTokenExpiration; // 5m
    private long refreshTokenExpiration; // 24h

}
