package com.pada.learnproject.flight.web.ticket;

import static com.pada.learnproject.flight.constant.TicketConstants.Urls.TICKETS;
import static com.pada.learnproject.flight.constant.TicketTestValues.createTicketRequest;
import static com.pada.learnproject.flight.validator.TicketValidator.validateCreateTicketResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.response.TicketResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class TicketControllerPostTicketIT extends TicketBaseIT {

    @Test
    void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(TICKETS)
                    .content(TestUtil.convertObjectToJsonBytes(createTicketRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, TicketResponse.class);
        validateCreateTicketResponse(response);
    }
}
