package com.pada.learnproject.flight.service.dto.request;

import java.time.LocalDateTime;

public record FlightRequest(String flightName, LocalDateTime flightStart, LocalDateTime flightEnd, Integer maxPassengerCount) {
}
