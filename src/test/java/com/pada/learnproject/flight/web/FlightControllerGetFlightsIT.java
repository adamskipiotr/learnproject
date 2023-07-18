package com.pada.learnproject.flight.web;

import static com.pada.learnproject.flight.constant.FlightConstants.Urls.FLIGHTS;
import static com.pada.learnproject.flight.validator.FlightValidator.validateFlightListWrapperWithWithThreeElementsInList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.pada.learnproject.flight.FlightBaseIT;
import com.pada.learnproject.flight.service.dto.FlightListWrapperResponse;
import org.junit.jupiter.api.Test;

class FlightControllerGetFlightsIT extends FlightBaseIT {

    @Test
    void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
        var result = mockMvc.perform(get(FLIGHTS))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, FlightListWrapperResponse.class);
        validateFlightListWrapperWithWithThreeElementsInList(response);
    }

    //
    //    @Test
    //    void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
    //    Exception {
    //        var result = mockMvc.perform(get(EXAMPLES + defaultEntityFilters()))
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString();
    //
    //        var response = objectMapper.readValue(result, ExampleListWrapperResponse.class);
    //        validateExampleListWrapperWithExampleListResponse(response);
    //    }
    //
    //    @Test
    //    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
    //        var result = mockMvc.perform(get(EXAMPLES + nonMatchingFilters()))
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString();
    //
    //        var response = objectMapper.readValue(result, ExampleListWrapperResponse.class);
    //        validateEmptyExampleListWrapperResponse(response);
    //    }
    //
    //    private String defaultEntityFilters() {
    //        return filterBy()
    //            .param(NAME, DEFAULT_EXAMPLE_ENTITY_NAME)
    //            .param(VALUE, DEFAULT_EXAMPLE_ENTITY_VALUE)
    //            .toQueryString();
    //    }
    //
    //    private String nonMatchingFilters() {
    //        return filterBy()
    //            .param(NAME, INVALID_DEFAULT_EXAMPLE_ENTITY_NAME)
    //            .toQueryString();
    //    }
}
