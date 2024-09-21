package com.example.deploystudy.global.security.session;

import com.example.deploystudy.domain.user.domain.User;
import com.example.deploystudy.domain.user.error.UserError;
import com.example.deploystudy.domain.user.repository.UserRepository;
import com.example.deploystudy.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSession {
    private final UserRepository userRepository;

    public User getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));
    }
}
