package com.pada.learnproject.flight.validator;

import static com.pada.learnproject.flight.constant.TicketTestValues.DEFAULT_REQUEST_TICKET_BASE_PRICE;
import static com.pada.learnproject.flight.constant.TicketTestValues.DEFAULT_REQUEST_TICKET_LUGGAGE_FEE;
import static com.pada.learnproject.flight.constant.TicketTestValues.DEFAULT_REQUEST_TICKET_TICKET_CLASS;
import static com.pada.learnproject.flight.constant.TicketTestValues.FIRST_TICKET_BASE_PRICE;
import static com.pada.learnproject.flight.constant.TicketTestValues.FIRST_TICKET_LUGGAGE_FEE;
import static com.pada.learnproject.flight.constant.TicketTestValues.FIRST_TICKET_TICKET_CLASS;
import static com.pada.learnproject.flight.constant.TicketTestValues.UPDATE_REQUEST_TICKET_BASE_PRICE;
import static com.pada.learnproject.flight.constant.TicketTestValues.UPDATE_REQUEST_TICKET_LUGGAGE_FEE;
import static com.pada.learnproject.flight.constant.TicketTestValues.UPDATE_REQUEST_TICKET_TICKET_CLASS;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.response.TicketListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.TicketResponse;
import org.springframework.stereotype.Component;

@Component
public class TicketValidator {

    public static void validateTicketListWrapperWithWithThreeElementsInList(
        TicketListWrapperResponse response) {
        var ticketResponseList = response.tickets();
        assertEquals(3, ticketResponseList.size());
    }

    public static void validateTicketListWrapperWithTicketListResponse(TicketListWrapperResponse response) {
        var ticketResponseList = response.tickets();
        assertEquals(1, ticketResponseList.size());

        var ticketListResponse = ticketResponseList.get(0);
        assertEquals(FIRST_TICKET_TICKET_CLASS, ticketListResponse.getTicketClass());
        assertEquals(FIRST_TICKET_BASE_PRICE, ticketListResponse.getBasePrice());
        assertEquals(FIRST_TICKET_LUGGAGE_FEE, ticketListResponse.getLuggageFee());

    }

    public static void validateEmptyTicketListWrapperResponse(TicketListWrapperResponse response) {
        var ticketResponseList = response.tickets();
        assertTrue(ticketResponseList.isEmpty());
    }

    public static void validateTicketResponseDetails(TicketResponse ticketResponse) {
        assertEquals(FIRST_TICKET_TICKET_CLASS, ticketResponse.getTicketClass());
        assertEquals(FIRST_TICKET_BASE_PRICE, ticketResponse.getBasePrice());
        assertEquals(FIRST_TICKET_LUGGAGE_FEE, ticketResponse.getLuggageFee());
    }

    public static void validateCreateTicketResponse(TicketResponse ticketResponse) {
        assertEquals(DEFAULT_REQUEST_TICKET_TICKET_CLASS, ticketResponse.getTicketClass());
        assertEquals(DEFAULT_REQUEST_TICKET_BASE_PRICE, ticketResponse.getBasePrice());
        assertEquals(DEFAULT_REQUEST_TICKET_LUGGAGE_FEE, ticketResponse.getLuggageFee());
    }

    public static void validateUpdateTicketResponse(TicketResponse ticketResponse) {
        assertEquals(UPDATE_REQUEST_TICKET_TICKET_CLASS, ticketResponse.getTicketClass());
        assertEquals(UPDATE_REQUEST_TICKET_BASE_PRICE, ticketResponse.getBasePrice());
        assertEquals(UPDATE_REQUEST_TICKET_LUGGAGE_FEE, ticketResponse.getLuggageFee());
    }
}
