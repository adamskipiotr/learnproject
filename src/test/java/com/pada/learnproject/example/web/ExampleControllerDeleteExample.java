package com.pada.learnproject.example.web;

import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.EXAMPLES;
import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.example.constant.ExampleEntityMother.NON_EXISTING_ID;
import static com.pada.learnproject.example.validator.ExampleValidator.validateExampleResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import org.junit.jupiter.api.Test;

public class ExampleControllerDeleteExample extends ExampleBaseIT {

    @Test
    public void shouldReturnDeletedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                delete(createUrlWithEntityId(exampleEntity.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleResponse.class);
        validateExampleResponse(response);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenWhenNonExistingIdProvided() throws Exception {
        mockMvc.perform(
                get(createUrlWithEntityId(NON_EXISTING_ID)))
            .andDo(print())
            .andExpect(status().isBadRequest());

        //TODO Add validation
    }
}
