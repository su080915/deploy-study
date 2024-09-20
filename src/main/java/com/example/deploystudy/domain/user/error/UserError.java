package com.example.deploystudy.domain.user.error;

import com.example.deploystudy.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserError implements CustomError {
    USERNAME_DUPLICATION(HttpStatus.BAD_REQUEST, "Username is already in use"),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "User not found"),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "Wrong password"),
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
