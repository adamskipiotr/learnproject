package com.pada.learnproject.flight.web.passenger;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.PassengerConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.PassengerTestValues.NON_EXISTING_ID;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createUpdatePassengerRequest;
import static com.pada.learnproject.flight.validator.PassengerValidator.validateUpdatePassengerResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.response.PassengerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class PassengerControllerPutPassengerIT extends PassengerBaseIT {

    @Test
    void shouldReturnUpdatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                put(createUrlWithEntityId(defaultPassenger.getId()))
                    .content(TestUtil.convertObjectToJsonBytes(createUpdatePassengerRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, PassengerResponse.class);
        validateUpdatePassengerResponse(response);
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
