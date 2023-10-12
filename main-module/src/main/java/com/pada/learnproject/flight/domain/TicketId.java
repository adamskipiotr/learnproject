package com.pada.learnproject.flight.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public record TicketId(Long value) {

    public TicketId {
        if (value < 0) {
            throw new IllegalArgumentException("Ticket ID cannot be negative");
        }
    }
}
