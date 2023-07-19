package com.pada.learnproject.flight.service.dto;

import java.time.LocalDateTime;

public record FlightRequest(LocalDateTime flightStart, LocalDateTime flightEnd) {
}
