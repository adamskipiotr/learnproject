package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.TicketClass;

public record TicketRequest(TicketClass ticketClass, Integer basePrice, Integer luggageFee) {
}
