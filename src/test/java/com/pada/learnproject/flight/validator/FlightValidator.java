package com.pada.learnproject.flight.validator;

import static com.pada.learnproject.flight.constant.FlightMother.DEFAULT_FLIGHT_END;
import static com.pada.learnproject.flight.constant.FlightMother.DEFAULT_FLIGHT_START;
import static com.pada.learnproject.flight.constant.FlightMother.UPDATE_FLIGHT_END;
import static com.pada.learnproject.flight.constant.FlightMother.UPDATE_FLIGHT_START;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.FlightResponse;
import org.springframework.stereotype.Component;

@Component
public class FlightValidator {

    public static void validateFlightResponse(FlightResponse flightResponse) {
        assertEquals(DEFAULT_FLIGHT_START, flightResponse.getFlightStart());
        assertEquals(DEFAULT_FLIGHT_END, flightResponse.getFlightEnd());
    }

    public static void validateUpdateFlightResponse(FlightResponse flightResponse) {
        assertEquals(UPDATE_FLIGHT_START, flightResponse.getFlightStart());
        assertEquals(UPDATE_FLIGHT_END, flightResponse.getFlightEnd());
    }
}
