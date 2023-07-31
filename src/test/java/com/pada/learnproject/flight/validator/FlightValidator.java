package com.pada.learnproject.flight.validator;

import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_END;
import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_REQUEST_END;
import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_REQUEST_START;
import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_START;
import static com.pada.learnproject.flight.constant.FlightTestValues.DEFAULT_FLIGHT_STATUS;
import static com.pada.learnproject.flight.constant.FlightTestValues.UPDATE_FLIGHT_END;
import static com.pada.learnproject.flight.constant.FlightTestValues.UPDATE_FLIGHT_START;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.response.FlightListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.FlightResponse;
import org.springframework.stereotype.Component;

@Component
public class FlightValidator {

    public static void validateFlightListWrapperWithWithThreeElementsInList(FlightListWrapperResponse response) {
        var flightListResponseList = response.flights();
        assertEquals(3, flightListResponseList.size());
    }

    public static void validateFlightListWrapperWithFlightListResponse(FlightListWrapperResponse response) {
        var flightListResponseList = response.flights();
        assertEquals(1, flightListResponseList.size());

        var flightListResponse = flightListResponseList.get(0);
        assertEquals(DEFAULT_FLIGHT_START, flightListResponse.getFlightStart());
        assertEquals(DEFAULT_FLIGHT_END, flightListResponse.getFlightEnd());
    }

    public static void validateEmptyFlightListWrapperResponse(FlightListWrapperResponse response) {
        var flightListResponseList = response.flights();
        assertTrue(flightListResponseList.isEmpty());
    }

    public static void validateFlightResponseDetails(FlightResponse flightResponse) {
        assertEquals(DEFAULT_FLIGHT_START, flightResponse.getFlightStart());
        assertEquals(DEFAULT_FLIGHT_END, flightResponse.getFlightEnd());
        assertEquals(DEFAULT_FLIGHT_STATUS, flightResponse.getFlightStatus());
    }

    public static void validateCreateFlightResponse(FlightResponse flightResponse) {
        assertEquals(DEFAULT_FLIGHT_REQUEST_START, flightResponse.getFlightStart());
        assertEquals(DEFAULT_FLIGHT_REQUEST_END, flightResponse.getFlightEnd());
        assertEquals(DEFAULT_FLIGHT_STATUS, flightResponse.getFlightStatus());
    }

    public static void validateUpdateFlightResponse(FlightResponse flightResponse) {
        assertEquals(UPDATE_FLIGHT_START, flightResponse.getFlightStart());
        assertEquals(UPDATE_FLIGHT_END, flightResponse.getFlightEnd());
        assertEquals(DEFAULT_FLIGHT_STATUS, flightResponse.getFlightStatus());

    }
}
