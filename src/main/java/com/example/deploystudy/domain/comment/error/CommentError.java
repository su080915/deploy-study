package com.example.deploystudy.domain.comment.error;

import com.example.deploystudy.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum CommentError implements CustomError {
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Comment not found"),
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
