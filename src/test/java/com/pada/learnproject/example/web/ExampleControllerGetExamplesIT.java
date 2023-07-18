package com.pada.learnproject.example.web;

import static com.pada.learnproject.common.util.FilterUtil.filterBy;
import static com.pada.learnproject.example.constant.ExampleEntityConstants.FilteringFields.NAME;
import static com.pada.learnproject.example.constant.ExampleEntityConstants.FilteringFields.VALUE;
import static com.pada.learnproject.example.constant.ExampleEntityConstants.Urls.EXAMPLES;
import static com.pada.learnproject.example.constant.ExampleEntityMother.DEFAULT_EXAMPLE_ENTITY_NAME;
import static com.pada.learnproject.example.constant.ExampleEntityMother.DEFAULT_EXAMPLE_ENTITY_VALUE;
import static com.pada.learnproject.example.constant.ExampleEntityMother.INVALID_DEFAULT_EXAMPLE_ENTITY_NAME;
import static com.pada.learnproject.example.validator.ExampleValidator.validateEmptyExampleListWrapperResponse;
import static com.pada.learnproject.example.validator.ExampleValidator.validateExampleListWrapperWithExampleListResponse;
import static com.pada.learnproject.example.validator.ExampleValidator.validateExampleListWrapperWithWithThreeElementsInList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.pada.learnproject.example.ExampleBaseIT;
import com.pada.learnproject.example.service.dto.response.ExampleListWrapperResponse;
import org.junit.jupiter.api.Test;

public class ExampleControllerGetExamplesIT extends ExampleBaseIT {

    @Test
    void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
        var result = mockMvc.perform(get(EXAMPLES))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleListWrapperResponse.class);
        validateExampleListWrapperWithWithThreeElementsInList(response);

    }

    @Test
    void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws Exception {
        var result = mockMvc.perform(get(EXAMPLES + defaultEntityFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleListWrapperResponse.class);
        validateExampleListWrapperWithExampleListResponse(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
        var result = mockMvc.perform(get(EXAMPLES + nonMatchingFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ExampleListWrapperResponse.class);
        validateEmptyExampleListWrapperResponse(response);
    }

    private String defaultEntityFilters() {
        return filterBy()
            .param(NAME, DEFAULT_EXAMPLE_ENTITY_NAME)
            .param(VALUE, DEFAULT_EXAMPLE_ENTITY_VALUE)
            .toQueryString();
    }

    private String nonMatchingFilters() {
        return filterBy()
            .param(NAME, INVALID_DEFAULT_EXAMPLE_ENTITY_NAME)
            .toQueryString();
    }
}
