package com.pada.learnproject.flight.web.ticket;

import static com.pada.learnproject.common.util.FilterUtil.filterBy;
import static com.pada.learnproject.flight.constant.TicketConstants.FilteringFields.BASE_PRICE;
import static com.pada.learnproject.flight.constant.TicketConstants.FilteringFields.LUGGAGE_FEE;
import static com.pada.learnproject.flight.constant.TicketConstants.FilteringFields.TICKET_CLASS;
import static com.pada.learnproject.flight.constant.TicketConstants.Urls.TICKETS;
import static com.pada.learnproject.flight.constant.TicketTestValues.FIRST_TICKET_BASE_PRICE;
import static com.pada.learnproject.flight.constant.TicketTestValues.FIRST_TICKET_TICKET_CLASS;
import static com.pada.learnproject.flight.constant.TicketTestValues.INVALID_TICKET_BASE_PRICE;
import static com.pada.learnproject.flight.constant.TicketTestValues.INVALID_TICKET_LUGGAGE_FEE;
import static com.pada.learnproject.flight.validator.TicketValidator.validateEmptyTicketListWrapperResponse;
import static com.pada.learnproject.flight.validator.TicketValidator.validateTicketListWrapperWithTicketListResponse;
import static com.pada.learnproject.flight.validator.TicketValidator.validateTicketListWrapperWithWithThreeElementsInList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.pada.learnproject.flight.service.dto.response.TicketListWrapperResponse;
import org.junit.jupiter.api.Test;

class TicketControllerGetTicketsIT extends TicketBaseIT {

    @Test
    void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
        var result = mockMvc.perform(get(TICKETS))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, TicketListWrapperResponse.class);
        validateTicketListWrapperWithWithThreeElementsInList(response);
    }

    @Test
    void shouldReturnResponseWithOneElementInListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
        Exception {
        var result = mockMvc.perform(get(TICKETS + defaultTicketFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, TicketListWrapperResponse.class);
        validateTicketListWrapperWithTicketListResponse(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
        var result = mockMvc.perform(get(TICKETS + nonMatchingFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, TicketListWrapperResponse.class);
        validateEmptyTicketListWrapperResponse(response);
    }

    private String defaultTicketFilters() {
        return filterBy()
            .param(TICKET_CLASS, FIRST_TICKET_TICKET_CLASS)
            .param(BASE_PRICE, FIRST_TICKET_BASE_PRICE)
            .param(LUGGAGE_FEE, FIRST_TICKET_BASE_PRICE)
            .toQueryString();
    }

    private String nonMatchingFilters() {
        return filterBy()
            .param(BASE_PRICE, INVALID_TICKET_BASE_PRICE)
            .param(LUGGAGE_FEE, INVALID_TICKET_LUGGAGE_FEE)
            .toQueryString();
    }
}
