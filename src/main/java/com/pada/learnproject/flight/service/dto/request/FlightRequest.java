package com.pada.learnproject.flight.service.dto.request;

import java.time.LocalDateTime;

public record FlightRequest(String flightName, LocalDateTime flightStart,
                            LocalDateTime flightEnd, Integer maxPassengerCount) {

    public FlightRequest {
        if (flightStart != null && flightEnd != null && flightStart.isAfter(flightEnd)) {
            throw new IllegalArgumentException("flight start must be before flight end.");
        }
    }
}
