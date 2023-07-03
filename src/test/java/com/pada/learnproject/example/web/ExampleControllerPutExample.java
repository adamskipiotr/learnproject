package com.pada.learnproject.example.web;

import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.EXAMPLES;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createExampleRequest;
import static com.pada.learnproject.example.constant.ExampleEntityMother.createUpdateExampleRequest;
import static com.pada.learnproject.example.validator.ExampleValidator.validateExampleResponse;
import static com.pada.learnproject.example.validator.ExampleValidator.validateUpdateExampleResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.pada.learnproject.common.TestUtil;
import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
public class ExampleControllerPutExample extends ExampleBaseIT {

    @Test
    //TODO fix
    public void shouldReturnUpdatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                put(EXAMPLES + "/" + exampleEntity.getId())
                    .content(TestUtil.convertObjectToJsonBytes(createUpdateExampleRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleResponse.class);
        validateUpdateExampleResponse(response);
    }
}
