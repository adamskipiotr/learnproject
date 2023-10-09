package com.pada.learnproject.example.web;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.example.constant.ExampleEntityMother.NON_EXISTING_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import com.pada.learnproject.example.validator.ExampleValidator;
import org.junit.jupiter.api.Test;

class ExampleControllerDeleteExampleIT extends ExampleBaseIT {

    @Test
    void shouldReturnDeletedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                delete(createUrlWithEntityId(exampleEntity.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleResponse.class);
        ExampleValidator.validateExampleResponse(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenWhenNonExistingIdProvided() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(NON_EXISTING_ID)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }
}
