package com.pada.learnproject.flight.web.ticket;

import static com.pada.learnproject.flight.constant.PassengerConstants.Urls.PASSENGERS;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createPassengerRequest;
import static com.pada.learnproject.flight.validator.PassengerValidator.validateCreatePassengerResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.PassengerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class TicketControllerPostTicketIT extends TicketBaseIT {

    @Test
    void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(PASSENGERS)
                    .content(TestUtil.convertObjectToJsonBytes(createPassengerRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, PassengerResponse.class);
        validateCreatePassengerResponse(response);
    }
}
