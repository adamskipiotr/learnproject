package com.pada.learnproject.example.web;

import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.EXAMPLES;
import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.example.constant.ExampleEntityMother.NON_EXISTING_ID;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createUpdateExampleRequest;
import static com.pada.learnproject.example.validator.ExampleValidator.validateUpdateExampleResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.TestUtil;
import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class ExampleControllerPutExample extends ExampleBaseIT {

    @Test
    public void shouldReturnUpdatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                put(createUrlWithEntityId(exampleEntity.getId()))
                    .content(TestUtil.convertObjectToJsonBytes(createUpdateExampleRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleResponse.class);
        validateUpdateExampleResponse(response);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenNonExistingIdProvided() throws Exception {
        mockMvc.perform(
                get(createUrlWithEntityId(NON_EXISTING_ID)))
            .andDo(print())
            .andExpect(status().isBadRequest());

        //TODO Add validation
    }
}
