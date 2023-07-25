package com.pada.learnproject.flight.constant;

import static com.pada.learnproject.flight.domain.WeatherCondition.CLEAR;
import static com.pada.learnproject.flight.domain.WeatherCondition.CLOUDY;
import static com.pada.learnproject.flight.domain.WeatherCondition.PARTIALLY_CLOUDY;
import static com.pada.learnproject.flight.domain.WeatherCondition.RAINING;
import static com.pada.learnproject.flight.domain.WeatherCondition.SNOWING;
import static com.pada.learnproject.flight.domain.WeatherCondition.THUNDERSTORM;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.WeatherCondition;
import com.pada.learnproject.flight.service.dto.AirportRequest;

public interface AirportTestValues {

    String FIRST_AIRPORT_NAME = "Airport Name 1";
    WeatherCondition FIRST_AIRPORT_WEATHER_CONDITION = CLEAR;

    String SECOND_AIRPORT_NAME = "Airport Name 2";
    WeatherCondition SECOND_AIRPORT_WEATHER_CONDITION = RAINING;

    String THIRD_AIRPORT_NAME = "Airport Name 3";
    WeatherCondition THIRD_AIRPORT_WEATHER_CONDITION = CLOUDY;

    String DEFAULT_REQUEST_AIRPORT_NAME = "Create Airport Name";
    WeatherCondition DEFAULT_REQUEST_AIRPORT_WEATHER_CONDITION = PARTIALLY_CLOUDY;

    String UPDATE_REQUEST_AIRPORT_NAME = "Update Airport Name ";
    WeatherCondition UPDATE_REQUEST_AIRPORT_WEATHER_CONDITION = SNOWING;

    String INVALID_AIRPORT_NAME = "Invalid Airport Name";
    WeatherCondition INVALID_AIRPORT_WEATHER_CONDITION = THUNDERSTORM;


    Long NON_EXISTING_ID = -1L;

    static Airport createDefaultTestAirport() {
        return Airport.builder()
            .name(FIRST_AIRPORT_NAME)
            .weatherCondition(FIRST_AIRPORT_WEATHER_CONDITION)
            .build();
    }

    static Airport createSecondTestAirport() {
        return Airport.builder()
            .name(SECOND_AIRPORT_NAME)
            .weatherCondition(SECOND_AIRPORT_WEATHER_CONDITION)
            .build();
    }

    static Airport createThirdTestAirport() {
        return Airport.builder()
            .name(THIRD_AIRPORT_NAME)
            .weatherCondition(THIRD_AIRPORT_WEATHER_CONDITION)
            .build();
    }

    static AirportRequest createAirportRequest() {
        return new AirportRequest(DEFAULT_REQUEST_AIRPORT_NAME, DEFAULT_REQUEST_AIRPORT_WEATHER_CONDITION);
    }

    static AirportRequest createUpdateAirportRequest() {
        return new AirportRequest(UPDATE_REQUEST_AIRPORT_NAME, UPDATE_REQUEST_AIRPORT_WEATHER_CONDITION);
    }
}
