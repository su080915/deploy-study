package com.example.deploystudy.global.exception;

import org.springframework.http.ResponseEntity;

public record ErrorResponse(
        int status,
        String message,
        String code
) {
    public static ResponseEntity<ErrorResponse> of(CustomException exception) {
        CustomError error = exception.getError();

        return ResponseEntity.status(error.getStatus())
                .body(new ErrorResponse(error.getStatus().value(), error.getMessage(), error.getCode()));
    }
}
