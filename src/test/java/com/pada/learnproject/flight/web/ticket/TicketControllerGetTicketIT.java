package com.pada.learnproject.flight.web.ticket;


import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.TicketConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.TicketTestValues.NON_EXISTING_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.flight.service.dto.TicketResponse;
import com.pada.learnproject.flight.validator.TicketValidator;
import org.junit.jupiter.api.Test;

class TicketControllerGetTicketIT extends TicketBaseIT {


    @Test
    void shouldReturnDefaultTicketWhenSearchingWithValidId() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(defaultTicket.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, TicketResponse.class);
        TicketValidator.validateTicketResponseDetails(response);
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
