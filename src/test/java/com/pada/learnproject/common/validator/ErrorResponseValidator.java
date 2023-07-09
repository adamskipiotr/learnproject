package com.pada.learnproject.common.validator;

import static com.pada.learnproject.common.constant.ExceptionsMother.BAD_REQUEST_CODE;
import static com.pada.learnproject.common.constant.ExceptionsMother.BAD_REQUEST_DESCRIPTION;
import static com.pada.learnproject.common.constant.ExceptionsMother.BAD_REQUEST_NAME;
import static com.pada.learnproject.example.constant.ExampleEntityMother.DEFAULT_EXAMPLE_ENTITY_NAME;
import static com.pada.learnproject.example.constant.ExampleEntityMother.DEFAULT_EXAMPLE_ENTITY_VALUE;
import static com.pada.learnproject.example.constant.ExampleEntityMother.UPDATE_EXAMPLE_ENTITY_NAME;
import static com.pada.learnproject.example.constant.ExampleEntityMother.UPDATE_EXAMPLE_ENTITY_VALUE;
import static com.pada.learnproject.example.validator.ManyToManyValidator.validateManyToManyResponseSet;
import static com.pada.learnproject.example.validator.ManyToManyValidator.validateUpdateManyToManyResponseSet;
import static com.pada.learnproject.example.validator.ManyToOneValidator.validateManyToOneResponseList;
import static com.pada.learnproject.example.validator.ManyToOneValidator.validateUpdateManyToOneResponseList;
import static com.pada.learnproject.example.validator.OneToOneValidator.validateOneToOneResponse;
import static com.pada.learnproject.example.validator.OneToOneValidator.validateUpdateOneToOneResponse;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.example.service.dto.response.ExampleListWrapperResponse;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseValidator {

    public static void validateErrorResponse(ErrorResponse response){
        assertEquals(BAD_REQUEST_CODE, response.getCode());
        assertEquals(BAD_REQUEST_NAME, response.getName());
        assertEquals(BAD_REQUEST_DESCRIPTION, response.getDescription());
    }
}
