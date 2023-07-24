package com.pada.learnproject.flight.service.dto;

import java.time.LocalDateTime;

public record AirportRequest(LocalDateTime flightStart, LocalDateTime flightEnd) {
}
