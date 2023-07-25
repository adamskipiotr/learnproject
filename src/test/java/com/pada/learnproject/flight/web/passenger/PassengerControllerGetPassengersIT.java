package com.pada.learnproject.flight.web.passenger;

import static com.pada.learnproject.common.util.FilterUtil.filterBy;
import static com.pada.learnproject.flight.constant.PassengerConstants.FilteringFields.AGE;
import static com.pada.learnproject.flight.constant.PassengerConstants.FilteringFields.FIRSTNAME;
import static com.pada.learnproject.flight.constant.PassengerConstants.FilteringFields.LASTNAME;
import static com.pada.learnproject.flight.constant.PassengerConstants.Urls.PASSENGERS;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_AGE;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_FIRST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_LAST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.INVALID_PASSENGER_AGE;
import static com.pada.learnproject.flight.constant.PassengerTestValues.INVALID_PASSENGER_FIRST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.INVALID_PASSENGER_LAST_NAME;
import static com.pada.learnproject.flight.validator.PassengerValidator.validateEmptyPassengerListWrapperResponse;
import static com.pada.learnproject.flight.validator.PassengerValidator.validatePassengerListWrapperWithPassengerListResponse;
import static com.pada.learnproject.flight.validator.PassengerValidator.validatePassengerListWrapperWithWithThreeElementsInList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.pada.learnproject.flight.service.dto.PassengerListWrapperResponse;
import org.junit.jupiter.api.Test;

class PassengerControllerGetPassengersIT extends PassengerBaseIT {

    @Test
    void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
        var result = mockMvc.perform(get(PASSENGERS))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, PassengerListWrapperResponse.class);
        validatePassengerListWrapperWithWithThreeElementsInList(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
        Exception {
        var result = mockMvc.perform(get(PASSENGERS + defaultPassengerFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, PassengerListWrapperResponse.class);
        validatePassengerListWrapperWithPassengerListResponse(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
        var result = mockMvc.perform(get(PASSENGERS + nonMatchingFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, PassengerListWrapperResponse.class);
        validateEmptyPassengerListWrapperResponse(response);
    }

    private String defaultPassengerFilters() {
        return filterBy()
            .param(FIRSTNAME, FIRST_PASSENGER_FIRST_NAME)
            .param(LASTNAME, FIRST_PASSENGER_LAST_NAME)
            .param(AGE, FIRST_PASSENGER_AGE)
            .toQueryString();
    }

    private String nonMatchingFilters() {
        return filterBy()
            .param(FIRSTNAME, INVALID_PASSENGER_FIRST_NAME)
            .param(LASTNAME, INVALID_PASSENGER_LAST_NAME)
            .param(AGE, INVALID_PASSENGER_AGE)
            .toQueryString();
    }
}
