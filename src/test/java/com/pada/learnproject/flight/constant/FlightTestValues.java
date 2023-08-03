package com.pada.learnproject.flight.constant;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.FlightStatus;
import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import java.time.LocalDateTime;
import java.util.HashSet;

public interface FlightTestValues {

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

    LocalDateTime INVALID_FILTER_FLIGHT_START = LocalDateTime.of(1999, 7, 11, 16, 30, 25);
    LocalDateTime INVALID_FILTER_FLIGHT_END = LocalDateTime.of(1999, 7, 11, 20, 30, 25);

    FlightStatus DEFAULT_FLIGHT_STATUS = FlightStatus.SCHEDULED;


    Long NON_EXISTING_ID = -1L;

    static Flight createDefaultTestFlight(Airport startAirport, Airport endAirport) {
        Flight flight =  Flight.builder()
            .flightStart(DEFAULT_FLIGHT_START)
            .flightEnd(DEFAULT_FLIGHT_END)
            .flightStatus(DEFAULT_FLIGHT_STATUS)
            .crewMembers(new HashSet<>())
            .build();
        bindFlightWithAirports(flight,startAirport,endAirport);
        return flight;
    }

    static Flight createSecondTestFlight(Airport startAirport, Airport endAirport) {
        Flight flight =  Flight.builder()
            .flightStart(SECOND_FLIGHT_START)
            .flightEnd(SECOND_FLIGHT_END)
            .crewMembers(new HashSet<>())
            .build();
        bindFlightWithAirports(flight,startAirport,endAirport);
        return flight;
    }

    static Flight createThirdTestFlight(Airport startAirport, Airport endAirport) {
        Flight flight =  Flight.builder()
            .flightStart(THIRD_FLIGHT_START)
            .flightEnd(THIRD_FLIGHT_END)
            .crewMembers(new HashSet<>())
            .build();
        bindFlightWithAirports(flight,startAirport,endAirport);
        return flight;
    }

    static void bindFlightWithAirports(Flight flight, Airport startAirport, Airport endAirport) {
        flight.setStartAirport(startAirport);
        startAirport.getDepartures().add(flight);
        flight.setEndAirport(endAirport);
        endAirport.getArrivals().add(flight);
    }



    static FlightRequest createFlightRequest() {
        return new FlightRequest(DEFAULT_FLIGHT_REQUEST_START, DEFAULT_FLIGHT_REQUEST_END);
    }

    static FlightRequest createUpdateFlightRequest() {
        return new FlightRequest(UPDATE_FLIGHT_START, UPDATE_FLIGHT_END);
    }
}
