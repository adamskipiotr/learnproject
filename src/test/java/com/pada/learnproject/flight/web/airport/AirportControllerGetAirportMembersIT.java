package com.pada.learnproject.flight.web.airport;

import static com.pada.learnproject.common.util.FilterUtil.filterBy;
import static com.pada.learnproject.flight.constant.AirportConstants.FilteringFields.NAME;
import static com.pada.learnproject.flight.constant.AirportConstants.FilteringFields.WEATHER_CONDITION;
import static com.pada.learnproject.flight.constant.AirportConstants.Urls.AIRPORTS;
import static com.pada.learnproject.flight.constant.AirportTestValues.FIRST_AIRPORT_NAME;
import static com.pada.learnproject.flight.constant.AirportTestValues.FIRST_AIRPORT_WEATHER_CONDITION;
import static com.pada.learnproject.flight.constant.AirportTestValues.INVALID_AIRPORT_NAME;
import static com.pada.learnproject.flight.constant.AirportTestValues.INVALID_AIRPORT_WEATHER_CONDITION;
import static com.pada.learnproject.flight.validator.AirportValidator.validateAirportListWrapperWithAirportListResponse;
import static com.pada.learnproject.flight.validator.AirportValidator.validateAirportListWrapperWithWithThreeElementsInList;
import static com.pada.learnproject.flight.validator.AirportValidator.validateEmptyAirportListWrapperResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.pada.learnproject.flight.service.dto.response.AirportListWrapperResponse;
import com.pada.learnproject.flight.web.FlightModuleBaseIT;
import org.junit.jupiter.api.Test;

class AirportControllerGetAirportMembersIT extends FlightModuleBaseIT {

    @Test
    void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
        var result = mockMvc.perform(get(AIRPORTS))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, AirportListWrapperResponse.class);
        validateAirportListWrapperWithWithThreeElementsInList(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
        Exception {
        var result = mockMvc.perform(get(AIRPORTS + defaultAirportFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, AirportListWrapperResponse.class);
        validateAirportListWrapperWithAirportListResponse(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
        var result = mockMvc.perform(get(AIRPORTS + nonMatchingFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, AirportListWrapperResponse.class);
        validateEmptyAirportListWrapperResponse(response);
    }

    private String defaultAirportFilters() {
        return filterBy()
            .param(NAME, FIRST_AIRPORT_NAME)
            .param(WEATHER_CONDITION, FIRST_AIRPORT_WEATHER_CONDITION)
            .toQueryString();
    }

    private String nonMatchingFilters() {
        return filterBy()
            .param(NAME, INVALID_AIRPORT_NAME)
            .param(WEATHER_CONDITION, INVALID_AIRPORT_WEATHER_CONDITION)
            .toQueryString();
    }
}
