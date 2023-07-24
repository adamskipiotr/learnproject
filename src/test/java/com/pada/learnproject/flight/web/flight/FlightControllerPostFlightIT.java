package com.pada.learnproject.flight.web.flight;

import static com.pada.learnproject.flight.constant.FlightConstants.Urls.FLIGHTS;
import static com.pada.learnproject.flight.constant.FlightTestValues.createFlightRequest;
import static com.pada.learnproject.flight.validator.FlightValidator.validateCreateFlightResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class FlightControllerPostFlightIT extends FlightBaseIT {

    @Test
    void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
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
