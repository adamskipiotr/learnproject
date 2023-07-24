package com.pada.learnproject.flight.web.flight;


import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.FlightConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.FlightTestValues.NON_EXISTING_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import com.pada.learnproject.flight.validator.FlightValidator;
import org.junit.jupiter.api.Test;

class FlightControllerGetFlightIT extends FlightBaseIT {


    @Test
    void shouldReturnDefaultFlightWhenSearchingWithValidId() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(defaultFlight.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, FlightResponse.class);
        FlightValidator.validateFlightResponseDetails(response);
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
