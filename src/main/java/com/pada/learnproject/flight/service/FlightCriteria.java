package com.pada.learnproject.flight.service;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightCriteria {

    private LocalDateTime flightStartLowerBoundary;

    private LocalDateTime flightStartUpperBoundary;
}
