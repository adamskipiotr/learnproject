package com.pada.learnproject.flight.service.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightRequest {

    private LocalDateTime flightStart;

    private LocalDateTime flightEnd;

}
