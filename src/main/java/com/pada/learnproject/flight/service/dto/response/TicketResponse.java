package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.TicketClass;

public record TicketResponse(TicketClass ticketClass, Integer basePrice, Integer luggageFee) {
}
