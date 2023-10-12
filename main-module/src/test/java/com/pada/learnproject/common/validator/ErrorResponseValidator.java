package com.pada.learnproject.common.validator;

import static com.pada.learnproject.common.constant.ExceptionsMother.BAD_REQUEST_CODE;
import static com.pada.learnproject.common.constant.ExceptionsMother.BAD_REQUEST_DESCRIPTION;
import static com.pada.learnproject.common.constant.ExceptionsMother.BAD_REQUEST_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseValidator {

    public static void validateErrorResponse(ErrorResponse response){
        assertEquals(BAD_REQUEST_CODE, response.getCode());
        assertEquals(BAD_REQUEST_NAME, response.getName());
        assertEquals(BAD_REQUEST_DESCRIPTION, response.getDescription());
    }
}
