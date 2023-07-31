package com.pada.learnproject.flight.constant;

import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.service.dto.request.PassengerRequest;

public interface PassengerTestValues {

    String FIRST_PASSENGER_FIRST_NAME = "First Passenger First Name";
    String FIRST_PASSENGER_LAST_NAME = "First Passenger Last Name";
    Integer FIRST_PASSENGER_AGE = 20;
    Boolean FIRST_PASSENGER_IS_PREMIUM = Boolean.FALSE;

    String SECOND_PASSENGER_FIRST_NAME = "Second Passenger First Name";
    String SECOND_PASSENGER_LAST_NAME = "Second Passenger Last Name";
    Integer SECOND_PASSENGER_AGE = 25;
    Boolean SECOND_PASSENGER_IS_PREMIUM = Boolean.TRUE;

    String THIRD_PASSENGER_FIRST_NAME = "Third Passenger First Name";
    String THIRD_PASSENGER_LAST_NAME = "Third Passenger Last Name";
    Integer THIRD_PASSENGER_AGE = 30;
    Boolean THIRD_PASSENGER_IS_PREMIUM = Boolean.FALSE;

    String DEFAULT_REQUEST_PASSENGER_FIRST_NAME = "Request Passenger First Name";
    String DEFAULT_REQUEST_PASSENGER_LAST_NAME = "Request Passenger Last Name";
    Integer DEFAULT_REQUEST_PASSENGER_AGE = 35;
    Boolean DEFAULT_REQUEST_PASSENGER_IS_PREMIUM = Boolean.FALSE;

    String UPDATE_REQUEST_PASSENGER_FIRST_NAME = "Update Passenger First Name";
    String UPDATE_REQUEST_PASSENGER_LAST_NAME = "Update Passenger Last Name";
    Integer UPDATE_REQUEST_PASSENGER_AGE = 35;
    Boolean UPDATE_REQUEST_PASSENGER_IS_PREMIUM = Boolean.TRUE;


    String INVALID_PASSENGER_FIRST_NAME = "Invalid Passenger First Name";
    String INVALID_PASSENGER_LAST_NAME = "Invalid Passenger Last Name";
    Integer INVALID_PASSENGER_AGE = 999;

    Long NON_EXISTING_ID = -1L;

    static Passenger createDefaultTestPassenger() {
        return Passenger.builder()
            .firstName(FIRST_PASSENGER_FIRST_NAME)
            .lastName(FIRST_PASSENGER_LAST_NAME)
            .age(FIRST_PASSENGER_AGE)
            .isPremium(FIRST_PASSENGER_IS_PREMIUM)
            .build();
    }

    static Passenger createSecondTestPassenger() {
        return Passenger.builder()
            .firstName(SECOND_PASSENGER_FIRST_NAME)
            .lastName(SECOND_PASSENGER_LAST_NAME)
            .age(SECOND_PASSENGER_AGE)
            .isPremium(SECOND_PASSENGER_IS_PREMIUM)
            .build();
    }

    static Passenger createThirdTestPassenger() {
        return Passenger.builder()
            .firstName(THIRD_PASSENGER_FIRST_NAME)
            .lastName(THIRD_PASSENGER_LAST_NAME)
            .age(THIRD_PASSENGER_AGE)
            .isPremium(THIRD_PASSENGER_IS_PREMIUM)
            .build();
    }

    static PassengerRequest createPassengerRequest() {
        return new PassengerRequest(DEFAULT_REQUEST_PASSENGER_FIRST_NAME, DEFAULT_REQUEST_PASSENGER_LAST_NAME,
            DEFAULT_REQUEST_PASSENGER_AGE, DEFAULT_REQUEST_PASSENGER_IS_PREMIUM);
    }

    static PassengerRequest createUpdatePassengerRequest() {
        return new PassengerRequest(UPDATE_REQUEST_PASSENGER_FIRST_NAME, UPDATE_REQUEST_PASSENGER_LAST_NAME,
            UPDATE_REQUEST_PASSENGER_AGE, UPDATE_REQUEST_PASSENGER_IS_PREMIUM);
    }
}
