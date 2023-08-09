package com.pada.learnproject.flight.service.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record FlightRequest(@NotNull String flightName, @NotNull LocalDateTime flightStart, @NotNull LocalDateTime flightEnd,
                            @NotNull Integer maxPassengerCount) {
}
