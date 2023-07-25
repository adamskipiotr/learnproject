package com.pada.learnproject.flight.validator;

import static com.pada.learnproject.flight.constant.PassengerTestValues.DEFAULT_REQUEST_PASSENGER_AGE;
import static com.pada.learnproject.flight.constant.PassengerTestValues.DEFAULT_REQUEST_PASSENGER_FIRST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.DEFAULT_REQUEST_PASSENGER_IS_PREMIUM;
import static com.pada.learnproject.flight.constant.PassengerTestValues.DEFAULT_REQUEST_PASSENGER_LAST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_AGE;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_FIRST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_IS_PREMIUM;
import static com.pada.learnproject.flight.constant.PassengerTestValues.FIRST_PASSENGER_LAST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.UPDATE_REQUEST_PASSENGER_AGE;
import static com.pada.learnproject.flight.constant.PassengerTestValues.UPDATE_REQUEST_PASSENGER_FIRST_NAME;
import static com.pada.learnproject.flight.constant.PassengerTestValues.UPDATE_REQUEST_PASSENGER_IS_PREMIUM;
import static com.pada.learnproject.flight.constant.PassengerTestValues.UPDATE_REQUEST_PASSENGER_LAST_NAME;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.PassengerListWrapperResponse;
import com.pada.learnproject.flight.service.dto.PassengerResponse;
import org.springframework.stereotype.Component;

@Component
public class PassengerValidator {

    public static void validatePassengerListWrapperWithWithThreeElementsInList(
        PassengerListWrapperResponse response) {
        var passengerResponseList = response.passengers();
        assertEquals(3, passengerResponseList.size());
    }

    public static void validatePassengerListWrapperWithPassengerListResponse(PassengerListWrapperResponse response) {
        var passengerResponseList = response.passengers();
        assertEquals(1, passengerResponseList.size());

        var crewMemberListResponse = passengerResponseList.get(0);
        assertEquals(FIRST_PASSENGER_FIRST_NAME, crewMemberListResponse.firstName());
        assertEquals(FIRST_PASSENGER_LAST_NAME, crewMemberListResponse.lastName());
    }

    public static void validateEmptyPassengerListWrapperResponse(PassengerListWrapperResponse response) {
        var passengerResponseList = response.passengers();
        assertTrue(passengerResponseList.isEmpty());
    }

    public static void validatePassengerResponseDetails(PassengerResponse passengerResponse) {
        assertEquals(FIRST_PASSENGER_FIRST_NAME, passengerResponse.firstName());
        assertEquals(FIRST_PASSENGER_LAST_NAME, passengerResponse.lastName());
        assertEquals(FIRST_PASSENGER_AGE, passengerResponse.age());
        assertEquals(FIRST_PASSENGER_IS_PREMIUM, passengerResponse.isPremium());
    }

    public static void validateCreatePassengerResponse(PassengerResponse passengerResponse) {
        assertEquals(DEFAULT_REQUEST_PASSENGER_FIRST_NAME, passengerResponse.firstName());
        assertEquals(DEFAULT_REQUEST_PASSENGER_LAST_NAME, passengerResponse.lastName());
        assertEquals(DEFAULT_REQUEST_PASSENGER_AGE, passengerResponse.age());
        assertEquals(DEFAULT_REQUEST_PASSENGER_IS_PREMIUM, passengerResponse.isPremium());
    }

    public static void validateUpdatePassengerResponse(PassengerResponse passengerResponse) {
        assertEquals(UPDATE_REQUEST_PASSENGER_FIRST_NAME, passengerResponse.firstName());
        assertEquals(UPDATE_REQUEST_PASSENGER_LAST_NAME, passengerResponse.lastName());
        assertEquals(UPDATE_REQUEST_PASSENGER_AGE, passengerResponse.age());
        assertEquals(UPDATE_REQUEST_PASSENGER_IS_PREMIUM, passengerResponse.isPremium());
    }
}
