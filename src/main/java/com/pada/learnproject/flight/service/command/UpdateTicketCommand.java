package com.pada.learnproject.flight.service.command;

import com.pada.learnproject.flight.domain.TicketId;
import com.pada.learnproject.flight.service.dto.request.TicketRequest;

public record UpdateTicketCommand(TicketId ticketId, TicketRequest ticketRequest) {

}
