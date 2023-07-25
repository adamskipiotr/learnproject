package com.pada.learnproject.flight.service.dto;

import java.time.LocalDateTime;

public record PassengerRequest(LocalDateTime flightStart, LocalDateTime flightEnd) {
}
