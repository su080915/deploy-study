package com.example.deploystudy.global.security.jwt.provider;


import com.example.deploystudy.global.security.jwt.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
//
//@Component
//@RequiredArgsConstructor
//public class JwtProvider {
//    private final JwtProperties jwtProperties;
//    private final UserRepository userRepository;
//    private SecretKey key;
//
//    @PostConstruct
//    protected void init() {
//        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.getSecretKey()));
//    }
//
//    public Jwt generateToken(String username, UserRole role) {
//        Date now = new Date();
//
//        String accessToken = Jwts.builder()
//                .setHeaderParam(Header.JWT_TYPE, JwtType.ACCESS)
//                .setSubject(username)
//                .claim("role", role)
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessTokenExpiration()))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//
//        String refreshToken = Jwts.builder()
//                .setHeaderParam(Header.JWT_TYPE, JwtType.REFRESH)
//                .setSubject(username)
//                .claim("role", role)
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshTokenExpiration()))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//
//        return new Jwt(accessToken, refreshToken);
//    }
//
//    public Authentication getAuthentication(String token) {
//        Jws<Claims> claims = getClaims(token);
//
//        if (getType(token) != JwtType.ACCESS) {
//            throw new CustomException(CustomErrorCode.INVALID_TOKEN_TYPE);
//        }
//
//        User user = userRepository.findByUsername(claims.getBody().getSubject()).orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//        UserDetails details = new CustomUserDetails(user);
//
//        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
//    }
//
//    public String extractToken(HttpServletRequest request) {
//        String token = request.getHeader("Authorization");
//
//        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
//            return token.substring(7);
//        }
//
//        return null;
//    }
//
//    public String getSubject(String token) {
//        return getClaims(token).getBody().getSubject();
//    }
//
//    private Jws<Claims> getClaims(String token) {
//        try {
//            return Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//        } catch (ExpiredJwtException e) {
//            throw new CustomException(CustomErrorCode.EXPIRED_JWT_TOKEN);
//        } catch (UnsupportedJwtException e) {
//            throw new CustomException(CustomErrorCode.UNSUPPORTED_JWT_TOKEN);
//        } catch (MalformedJwtException e) {
//            throw new CustomException(CustomErrorCode.MALFORMED_JWT_TOKEN);
//        } catch (IllegalArgumentException e) {
//            throw new CustomException(CustomErrorCode.INVALID_JWT_TOKEN);
//        }
//    }
//
//    public JwtType getType(String token) {
//        return JwtType.valueOf(Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getHeader()
//                .get(Header.JWT_TYPE).toString()
//        );
//    }
//
//}