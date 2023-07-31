package com.pada.learnproject.flight.web.ticket;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.TicketConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.TicketTestValues.NON_EXISTING_ID;
import static com.pada.learnproject.flight.constant.TicketTestValues.createUpdateTicketRequest;
import static com.pada.learnproject.flight.validator.TicketValidator.validateUpdateTicketResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.response.TicketResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class TicketControllerPutTicketIT extends TicketBaseIT {

    @Test
    void shouldReturnUpdatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                put(createUrlWithEntityId(defaultTicket.getId()))
                    .content(TestUtil.convertObjectToJsonBytes(createUpdateTicketRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, TicketResponse.class);
        validateUpdateTicketResponse(response);
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
