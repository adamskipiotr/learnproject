package com.pada.learnproject.flight.service.dto.request;

import java.time.LocalDateTime;

public record FlightRequest(LocalDateTime flightStart, LocalDateTime flightEnd) {
}
