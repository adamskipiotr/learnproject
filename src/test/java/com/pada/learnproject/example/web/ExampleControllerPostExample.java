package com.pada.learnproject.example.web;

import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.EXAMPLES;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createExampleRequest;
import static com.pada.learnproject.example.validator.ExampleValidator.validateExampleResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.TestUtil;
import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
public class ExampleControllerPostExample extends ExampleBaseIT {

    @Test
    public void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(EXAMPLES)
                    .content(TestUtil.convertObjectToJsonBytes(createExampleRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleResponse.class);
        validateExampleResponse(response);
    }
}
