package com.pada.learnproject.flight.web;

import static com.pada.learnproject.flight.constant.FlightConstants.Urls.FLIGHTS;
import static com.pada.learnproject.flight.constant.FlightMother.createFlightRequest;
import static com.pada.learnproject.flight.validator.FlightValidator.validateCreateFlightResponse;
import static com.pada.learnproject.flight.validator.FlightValidator.validateFlightResponseDetails;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.FlightBaseIT;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class FlightControllerPostFlight extends FlightBaseIT {

    @Test
    public void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(FLIGHTS)
                    .content(TestUtil.convertObjectToJsonBytes(createFlightRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, FlightResponse.class);
        validateCreateFlightResponse(response);
    }
}
