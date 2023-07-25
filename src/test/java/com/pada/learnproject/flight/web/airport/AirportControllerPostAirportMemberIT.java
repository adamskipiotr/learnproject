package com.pada.learnproject.flight.web.airport;

import static com.pada.learnproject.flight.constant.AirportConstants.Urls.AIRPORTS;
import static com.pada.learnproject.flight.constant.AirportTestValues.createAirportRequest;
import static com.pada.learnproject.flight.validator.AirportValidator.validateCreateAirportResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.AirportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class AirportControllerPostAirportMemberIT extends AirportMemberBaseIT {

    @Test
    void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(AIRPORTS)
                    .content(TestUtil.convertObjectToJsonBytes(createAirportRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, AirportResponse.class);
        validateCreateAirportResponse(response);
    }
}
