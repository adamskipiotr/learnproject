package com.pada.learnproject.flight.constant;

import static com.pada.learnproject.flight.domain.WeatherCondition.CLEAR;
import static com.pada.learnproject.flight.domain.WeatherCondition.CLOUDY;
import static com.pada.learnproject.flight.domain.WeatherCondition.PARTIALLY_CLOUDY;
import static com.pada.learnproject.flight.domain.WeatherCondition.RAINING;
import static com.pada.learnproject.flight.domain.WeatherCondition.SNOWING;
import static com.pada.learnproject.flight.domain.WeatherCondition.THUNDERSTORM;

import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.domain.WeatherCondition;
import com.pada.learnproject.flight.service.dto.PassengerRequest;

public interface PassengerTestValues {


    Long NON_EXISTING_ID = -1L;

    static Passenger createDefaultTestPassenger() {
        return Passenger.builder()
            .name(FIRST_AIRPORT_NAME)
            .weatherCondition(FIRST_AIRPORT_WEATHER_CONDITION)
            .build();
    }

    static Passenger createSecondTestPassenger() {
        return Passenger.builder()
            .name(SECOND_AIRPORT_NAME)
            .weatherCondition(SECOND_AIRPORT_WEATHER_CONDITION)
            .build();
    }

    static Passenger createThirdTestPassenger() {
        return Passenger.builder()
            .name(THIRD_AIRPORT_NAME)
            .weatherCondition(THIRD_AIRPORT_WEATHER_CONDITION)
            .build();
    }

    static PassengerRequest createPassengerRequest() {
        return new PassengerRequest(DEFAULT_REQUEST_AIRPORT_NAME, DEFAULT_REQUEST_AIRPORT_WEATHER_CONDITION);
    }

    static PassengerRequest createUpdatePassengerRequest() {
        return new PassengerRequest(UPDATE_REQUEST_AIRPORT_NAME, UPDATE_REQUEST_AIRPORT_WEATHER_CONDITION);
    }
}
