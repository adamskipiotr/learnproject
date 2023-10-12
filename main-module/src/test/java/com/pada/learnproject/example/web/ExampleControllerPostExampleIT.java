package com.pada.learnproject.example.web;

import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.EXAMPLES;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createExampleRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import com.pada.learnproject.example.validator.ExampleValidator;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class ExampleControllerPostExampleIT extends ExampleBaseIT {

    @Test
    void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(EXAMPLES)
                    .content(TestUtil.convertObjectToJsonBytes(createExampleRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleResponse.class);
        ExampleValidator.validateExampleResponse(response);
    }
}
