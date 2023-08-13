package com.pada.learnproject.flight.web.flight;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.FlightConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.FlightTestValues.NON_EXISTING_ID;
import static com.pada.learnproject.flight.constant.FlightTestValues.createUpdateFlightRequest;
import static com.pada.learnproject.flight.validator.FlightValidator.validateUpdateFlightResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.response.FlightResponse;
import com.pada.learnproject.flight.web.FlightModuleBaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class FlightControllerPutUpdateFlightStatusIT extends FlightModuleBaseIT {

    @Test
    void shouldReturnUpdatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                put(createUrlWithEntityId(defaultFlight.getId()))
                    .content(TestUtil.convertObjectToJsonBytes(createUpdateFlightRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, FlightResponse.class);
        validateUpdateFlightResponse(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenNonExistingIdProvided() throws Exception {
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
