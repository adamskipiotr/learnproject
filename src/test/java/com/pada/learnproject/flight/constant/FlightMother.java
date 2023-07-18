package com.pada.learnproject.flight.constant;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.service.dto.FlightRequest;
import java.time.LocalDateTime;

public interface FlightMother {

    LocalDateTime DEFAULT_FLIGHT_START = LocalDateTime.now();
    LocalDateTime DEFAULT_FLIGHT_END = LocalDateTime.now().plus(1, HOURS);

    LocalDateTime SECOND_FLIGHT_START = LocalDateTime.now();
    LocalDateTime SECOND_FLIGHT_END = LocalDateTime.now().plus(1, HOURS);

    LocalDateTime THIRD_FLIGHT_START = LocalDateTime.now();
    LocalDateTime THIRD_FLIGHT_END = LocalDateTime.now().plus(1, HOURS);

    LocalDateTime DEFAULT_FLIGHT_REQUEST_START = LocalDateTime.now().plus(1, DAYS);
    LocalDateTime DEFAULT_FLIGHT_REQUEST_END = LocalDateTime.now().plus(1, DAYS).plus(1, HOURS);

    LocalDateTime UPDATE_FLIGHT_START = LocalDateTime.now().minus(1, DAYS);
    LocalDateTime UPDATE_FLIGHT_END = LocalDateTime.now().minus(1, DAYS).minus(1, HOURS);

    Long NON_EXISTING_ID = -1L;

    static Flight createDefaultTestFlight() {
        return Flight.builder()
            .flightStart(DEFAULT_FLIGHT_START)
            .flightEnd(DEFAULT_FLIGHT_END)
            .build();
    }

    static Flight createSecondTestFlight() {
        return Flight.builder()
            .flightStart(SECOND_FLIGHT_START)
            .flightEnd(SECOND_FLIGHT_END)
            .build();
    }

    static Flight createThirdTestFlight() {
        return Flight.builder()
            .flightStart(THIRD_FLIGHT_START)
            .flightEnd(THIRD_FLIGHT_END)
            .build();
    }

    static FlightRequest createFlightRequest() {
        return new FlightRequest(DEFAULT_FLIGHT_REQUEST_START, DEFAULT_FLIGHT_REQUEST_END);
    }

    static FlightRequest createUpdateFlightRequest() {
        return new FlightRequest(UPDATE_FLIGHT_START, UPDATE_FLIGHT_END);
    }
}
