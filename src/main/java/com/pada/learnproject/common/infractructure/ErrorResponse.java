package com.pada.learnproject.common.infractructure;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Data
@Builder
public class ErrorResponse {

    private final String code;
    private final String name;
    private final String description;
}
