package com.pada.learnproject.example.validator;

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
public class ExampleValidator {

    public static void validateExampleListWrapperWithExampleListResponse(ExampleListWrapperResponse response) {
        var exampleListResponseList = response.exampleListResponseList();
        assertEquals(1, exampleListResponseList.size());

        var exampleListResponse = exampleListResponseList.get(0);
        assertEquals(DEFAULT_EXAMPLE_ENTITY_NAME, exampleListResponse.name());
        assertEquals(DEFAULT_EXAMPLE_ENTITY_VALUE, exampleListResponse.value());
    }

    public static void validateExampleListWrapperWithWithThreeElementsInList(ExampleListWrapperResponse response) {
        var exampleListResponseList = response.exampleListResponseList();
        assertEquals(3, exampleListResponseList.size());
    }

    public static void validateEmptyExampleListWrapperResponse(ExampleListWrapperResponse response) {
        var exampleListResponseList = response.exampleListResponseList();
        assertTrue(exampleListResponseList.isEmpty());
    }

    public static void validateExampleResponse(ExampleResponse exampleResponse){
        assertEquals(DEFAULT_EXAMPLE_ENTITY_NAME, exampleResponse.name());
        assertEquals(DEFAULT_EXAMPLE_ENTITY_VALUE, exampleResponse.value());
        validateOneToOneResponse(exampleResponse.oneToOneResponse());
        validateManyToOneResponseList(exampleResponse.manyToOneResponseList());
        validateManyToManyResponseSet(exampleResponse.manyToManyResponseSet());
    }

    public static void validateUpdateExampleResponse(ExampleResponse exampleResponse){
        assertEquals(UPDATE_EXAMPLE_ENTITY_NAME, exampleResponse.name());
        assertEquals(UPDATE_EXAMPLE_ENTITY_VALUE, exampleResponse.value());
        validateUpdateOneToOneResponse(exampleResponse.oneToOneResponse());
        validateUpdateManyToOneResponseList(exampleResponse.manyToOneResponseList());
        validateUpdateManyToManyResponseSet(exampleResponse.manyToManyResponseSet());
    }
}
