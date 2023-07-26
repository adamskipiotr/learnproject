package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.FlightStatus;
import java.time.LocalDateTime;

public record FlightResponse(
    LocalDateTime flightStart,
    LocalDateTime flightEnd,
    FlightStatus flightStatus
) {
}
