package com.example.deploystudy.global.exception;

import org.springframework.http.HttpStatus;

public interface CustomError {
    HttpStatus getStatus();
    String getMessage();
    String getCode();
}
