package com.pada.learnproject.flight.web.airport;


import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.AirportConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.AirportTestValues.NON_EXISTING_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.flight.service.dto.response.AirportResponse;
import com.pada.learnproject.flight.validator.AirportValidator;
import org.junit.jupiter.api.Test;

class AirportControllerGetAirportIT extends AirportBaseIT {


    @Test
    void shouldReturnDefaultAirportWhenSearchingWithValidId() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(defaultAirport.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, AirportResponse.class);
        AirportValidator.validateAirportResponseDetails(response);
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
