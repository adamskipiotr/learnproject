package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.FlightStatus;
import java.time.LocalDateTime;

public record PassengerResponse(
    LocalDateTime flightStart,
    LocalDateTime flightEnd,
    FlightStatus flightStatus
) {
}
