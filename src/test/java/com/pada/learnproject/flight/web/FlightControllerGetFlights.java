package com.pada.learnproject.flight.web;

import com.pada.learnproject.flight.FlightBaseIT;

public class FlightControllerGetFlights extends FlightBaseIT {

    //    @Test
    //    public void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
    //        var result = mockMvc.perform(get(EXAMPLES))
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString();
    //
    //        var response = objectMapper.readValue(result, ExampleListWrapperResponse.class);
    //        validateExampleListWrapperWithWithThreeElementsInList(response);
    //
    //    }
    //
    //    @Test
    //    public void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
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
    //    public void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
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
