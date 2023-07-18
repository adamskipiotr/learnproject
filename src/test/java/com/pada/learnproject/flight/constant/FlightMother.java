package com.pada.learnproject.flight.constant;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.service.dto.FlightRequest;
import java.time.LocalDateTime;

public interface FlightMother {

    LocalDateTime DEFAULT_FLIGHT_START = LocalDateTime.of(2023, 7, 11, 16, 30, 25);
    LocalDateTime DEFAULT_FLIGHT_END = LocalDateTime.of(2023, 7, 11, 20, 30, 25);

    LocalDateTime SECOND_FLIGHT_START = LocalDateTime.of(2023, 7, 22, 16, 30, 25);
    LocalDateTime SECOND_FLIGHT_END = LocalDateTime.of(2023, 7, 22, 20, 30, 25);

    LocalDateTime THIRD_FLIGHT_START = LocalDateTime.of(2023, 7, 30, 18, 30, 25);
    LocalDateTime THIRD_FLIGHT_END = LocalDateTime.of(2023, 7, 30, 20, 30, 25);

    LocalDateTime DEFAULT_FLIGHT_REQUEST_START = LocalDateTime.of(2023, 8, 1, 20, 30, 25);

    LocalDateTime DEFAULT_FLIGHT_REQUEST_END = LocalDateTime.of(2023, 8, 1, 20, 30, 25);


    LocalDateTime UPDATE_FLIGHT_START = LocalDateTime.of(2023, 9, 10, 20, 30, 25);

    LocalDateTime UPDATE_FLIGHT_END = LocalDateTime.of(2023, 9, 10, 20, 30, 25);


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
