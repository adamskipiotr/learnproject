package com.pada.learnproject.flight.web;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.FlightConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.FlightMother.NON_EXISTING_ID;
import static com.pada.learnproject.flight.validator.FlightValidator.validateFlightResponseDetails;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.flight.FlightBaseIT;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import org.junit.jupiter.api.Test;

class FlightControllerDeleteFlightIT extends FlightBaseIT {

    @Test
    void shouldReturnDeletedFlightWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                delete(createUrlWithEntityId(defaultFlight.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, FlightResponse.class);
        validateFlightResponseDetails(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenWhenNonExistingIdProvided() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(NON_EXISTING_ID)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }
}
