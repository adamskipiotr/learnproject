package com.pada.learnproject.flight.constant;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.FlightStatus;
import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import java.time.LocalDateTime;
import java.util.HashSet;

public interface FlightTestValues {

    String DEFAULT_FLIGHT_NAME = "Default flight name";
    LocalDateTime DEFAULT_FLIGHT_START = LocalDateTime.of(2023, 7, 11, 16, 30, 25);
    LocalDateTime DEFAULT_FLIGHT_END = LocalDateTime.of(2023, 7, 11, 20, 30, 25);
    Integer DEFAULT_MAX_PASSENGER_COUNT = 100;

    String SECOND_FLIGHT_NAME = "Second flight name";
    LocalDateTime SECOND_FLIGHT_START = LocalDateTime.of(2023, 7, 22, 16, 30, 25);
    LocalDateTime SECOND_FLIGHT_END = LocalDateTime.of(2023, 7, 22, 20, 30, 25);
    Integer SECOND_MAX_PASSENGER_COUNT = 200;


    String THIRD_FLIGHT_NAME = "Third flight name";
    LocalDateTime THIRD_FLIGHT_START = LocalDateTime.of(2023, 7, 30, 18, 30, 25);
    LocalDateTime THIRD_FLIGHT_END = LocalDateTime.of(2023, 7, 30, 20, 30, 25);
    Integer THIRD_MAX_PASSENGER_COUNT = 300;

    String DEFAULT_FLIGHT_REQUEST_NAME = "Default request flight name";
    LocalDateTime DEFAULT_FLIGHT_REQUEST_START = LocalDateTime.of(2023, 8, 1, 20, 30, 25);
    LocalDateTime DEFAULT_FLIGHT_REQUEST_END = LocalDateTime.of(2023, 8, 1, 20, 30, 25);
    Integer DEFAULT_FLIGHT_REQUEST_MAX_PASSENGER_COUNT = 400;


    String UPDATE_FLIGHT_NAME = "Update request flight name";
    LocalDateTime UPDATE_FLIGHT_START = LocalDateTime.of(2023, 9, 10, 20, 30, 25);
    LocalDateTime UPDATE_FLIGHT_END = LocalDateTime.of(2023, 9, 10, 20, 30, 25);
    Integer UPDATE_FLIGHT_REQUEST_MAX_PASSENGER_COUNT = 300;


    LocalDateTime INVALID_FILTER_FLIGHT_START = LocalDateTime.of(1999, 7, 11, 16, 30, 25);
    LocalDateTime INVALID_FILTER_FLIGHT_END = LocalDateTime.of(1999, 7, 11, 20, 30, 25);

    FlightStatus DEFAULT_FLIGHT_STATUS = FlightStatus.SCHEDULED;


    Long NON_EXISTING_ID = -1L;

    static Flight createDefaultTestFlight(Airport startAirport, Airport endAirport, CrewMember crewMember) {
        Flight flight = Flight.builder()
            .flightName(DEFAULT_FLIGHT_NAME)
            .flightStart(DEFAULT_FLIGHT_START)
            .flightEnd(DEFAULT_FLIGHT_END)
            .flightStatus(DEFAULT_FLIGHT_STATUS)
            .maxPassengerCount(DEFAULT_MAX_PASSENGER_COUNT)
            .crewMembers(new HashSet<>())
            .build();
        bindFlightWithAirports(flight, startAirport, endAirport);
        return flight;
    }

    static Flight createSecondTestFlight(Airport startAirport, Airport endAirport, CrewMember crewMember) {
        Flight flight = Flight.builder()
            .flightName(SECOND_FLIGHT_NAME)
            .flightStart(SECOND_FLIGHT_START)
            .flightEnd(SECOND_FLIGHT_END)
            .maxPassengerCount(SECOND_MAX_PASSENGER_COUNT)
            .crewMembers(new HashSet<>())
            .build();
        bindFlightWithAirports(flight, startAirport, endAirport);
                return flight;
    }

    static Flight createThirdTestFlight(Airport startAirport, Airport endAirport, CrewMember crewMember) {
        Flight flight = Flight.builder()
            .flightName(THIRD_FLIGHT_NAME)
            .flightStart(THIRD_FLIGHT_START)
            .flightEnd(THIRD_FLIGHT_END)
            .maxPassengerCount(THIRD_MAX_PASSENGER_COUNT)
            .crewMembers(new HashSet<>())
            .build();
        bindFlightWithAirports(flight, startAirport, endAirport);
        return flight;
    }

    private static void bindFlightWithAirports(Flight flight, Airport startAirport, Airport endAirport) {
        flight.setStartAirport(startAirport);
        startAirport.getDepartures().add(flight);
        flight.setEndAirport(endAirport);
        endAirport.getArrivals().add(flight);
    }

    static FlightRequest createFlightRequest() {
        return new FlightRequest(DEFAULT_FLIGHT_REQUEST_NAME, DEFAULT_FLIGHT_REQUEST_START, DEFAULT_FLIGHT_REQUEST_END,
            DEFAULT_FLIGHT_REQUEST_MAX_PASSENGER_COUNT);
    }

    static FlightRequest createUpdateFlightRequest() {
        return new FlightRequest(UPDATE_FLIGHT_NAME, UPDATE_FLIGHT_START, UPDATE_FLIGHT_END,
            UPDATE_FLIGHT_REQUEST_MAX_PASSENGER_COUNT);
    }
}
