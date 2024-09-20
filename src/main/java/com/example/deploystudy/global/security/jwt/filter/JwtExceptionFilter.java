package com.example.deploystudy.global.security.jwt.filter;

import com.example.deploystudy.global.exception.CustomError;
import com.example.deploystudy.global.exception.CustomException;
import com.example.deploystudy.global.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtExceptionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            sendErrorResponse(response, e);
        }
    }

    private void sendErrorResponse(HttpServletResponse response, CustomException e) throws IOException {
        CustomError error = e.getError();

        response.setStatus(error.getStatus().value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        map.put("message", error.getMessage());
        map.put("status", error.getStatus());

        response.getWriter().write(mapper.writeValueAsString(map));
    }
}
