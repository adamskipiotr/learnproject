package com.pada.learnproject.flight.web;

import static com.pada.learnproject.common.util.FilterUtil.filterBy;
import static com.pada.learnproject.flight.constant.FlightConstants.FilteringFields.FLIGHT_START_LOWER_BOUNDARY;
import static com.pada.learnproject.flight.constant.FlightConstants.FilteringFields.FLIGHT_START_UPPER_BOUNDARY;
import static com.pada.learnproject.flight.constant.FlightConstants.Urls.FLIGHTS;
import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_END;
import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_START;
import static com.pada.learnproject.flight.constant.FlightTestValues.INVALID_FILTER_FLIGHT_END;
import static com.pada.learnproject.flight.constant.FlightTestValues.INVALID_FILTER_FLIGHT_START;
import static com.pada.learnproject.flight.validator.FlightValidator.validateEmptyFlightListWrapperResponse;
import static com.pada.learnproject.flight.validator.FlightValidator.validateFlightListWrapperWithFlightListResponse;
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

        @Test
        void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
        Exception {
            var result = mockMvc.perform(get(FLIGHTS + defaultFlightFilters()))
                .andReturn()
                .getResponse()
                .getContentAsString();

            var response = objectMapper.readValue(result, FlightListWrapperResponse.class);
            validateFlightListWrapperWithFlightListResponse(response);
        }

    @Test
    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
        var result = mockMvc.perform(get(FLIGHTS + nonMatchingFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, FlightListWrapperResponse.class);
        validateEmptyFlightListWrapperResponse(response);
    }

    private String defaultFlightFilters() {
        return filterBy()
            .param(FLIGHT_START_LOWER_BOUNDARY, DEFAULT_FLIGHT_START)
            .param(FLIGHT_START_UPPER_BOUNDARY, DEFAULT_FLIGHT_END)
            .toQueryString();
    }

    private String nonMatchingFilters() {
        return filterBy()
            .param(FLIGHT_START_LOWER_BOUNDARY, INVALID_FILTER_FLIGHT_START)
            .param(FLIGHT_START_UPPER_BOUNDARY, INVALID_FILTER_FLIGHT_END)
            .toQueryString();
    }
}
