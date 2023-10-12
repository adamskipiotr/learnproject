package com.pada.learnproject.common.infractructure;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    ResponseEntity<Object> handleException(RuntimeException exception) {
        return buildExceptionResponse(BAD_REQUEST, "400", "Bad Request", "Exception handling in progress");
    }

    private ResponseEntity<Object> buildExceptionResponse(
        HttpStatus httpStatus, String code, String name, String description) {
        var response = ErrorResponse.builder()
            .code(code)
            .name(name)
            .description(Optional.ofNullable(description).orElse(name))
            .build();

        return ResponseEntity.status(httpStatus).body(response);
    }
}
