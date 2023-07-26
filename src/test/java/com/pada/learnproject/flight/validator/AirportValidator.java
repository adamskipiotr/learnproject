package com.pada.learnproject.flight.validator;

import static com.pada.learnproject.flight.constant.AirportTestValues.DEFAULT_REQUEST_AIRPORT_NAME;
import static com.pada.learnproject.flight.constant.AirportTestValues.DEFAULT_REQUEST_AIRPORT_WEATHER_CONDITION;
import static com.pada.learnproject.flight.constant.AirportTestValues.FIRST_AIRPORT_NAME;
import static com.pada.learnproject.flight.constant.AirportTestValues.FIRST_AIRPORT_WEATHER_CONDITION;
import static com.pada.learnproject.flight.constant.AirportTestValues.UPDATE_REQUEST_AIRPORT_NAME;
import static com.pada.learnproject.flight.constant.AirportTestValues.UPDATE_REQUEST_AIRPORT_WEATHER_CONDITION;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.response.AirportListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.AirportResponse;
import org.springframework.stereotype.Component;

@Component
public class AirportValidator {

    public static void validateAirportListWrapperWithWithThreeElementsInList(AirportListWrapperResponse response) {
        var airportListResponses = response.airports();
        assertEquals(3, airportListResponses.size());
    }

    public static void validateAirportListWrapperWithAirportListResponse(AirportListWrapperResponse response) {
        var airportResponseList = response.airports();
        assertEquals(1, airportResponseList.size());

        var airportListResponse = airportResponseList.get(0);
        assertEquals(FIRST_AIRPORT_NAME, airportListResponse.name());
        assertEquals(FIRST_AIRPORT_WEATHER_CONDITION, airportListResponse.weatherCondition());
    }

    public static void validateEmptyAirportListWrapperResponse(AirportListWrapperResponse response) {
        var airportResponseList = response.airports();
        assertTrue(airportResponseList.isEmpty());
    }

    public static void validateAirportResponseDetails(AirportResponse airportResponse) {
        assertEquals(FIRST_AIRPORT_NAME, airportResponse.name());
        assertEquals(FIRST_AIRPORT_WEATHER_CONDITION, airportResponse.weatherCondition());
    }

    public static void validateCreateAirportResponse(AirportResponse airportResponse) {
        assertEquals(DEFAULT_REQUEST_AIRPORT_NAME, airportResponse.name());
        assertEquals(DEFAULT_REQUEST_AIRPORT_WEATHER_CONDITION, airportResponse.weatherCondition());
    }

    public static void validateUpdateAirportResponse(AirportResponse airportResponse) {
        assertEquals(UPDATE_REQUEST_AIRPORT_NAME, airportResponse.name());
        assertEquals(UPDATE_REQUEST_AIRPORT_WEATHER_CONDITION, airportResponse.weatherCondition());

    }
}
