package com.example.deploystudy.domain.post.error;

import com.example.deploystudy.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum PostError implements CustomError {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post not found"),
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
