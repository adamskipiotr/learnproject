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
import static com.pada.learnproject.flight.validator.TicketValidator.validateTicketResponseDetails;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.response.PassengerListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.PassengerResponse;
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
        assertEquals(FIRST_PASSENGER_FIRST_NAME, passengerResponse.getFirstName());
        assertEquals(FIRST_PASSENGER_LAST_NAME, passengerResponse.getLastName());
        assertEquals(FIRST_PASSENGER_AGE, passengerResponse.getAge());
        assertEquals(FIRST_PASSENGER_IS_PREMIUM, passengerResponse.getIsPremium());
        for(var ticket: passengerResponse.getTickets()){
            validateTicketResponseDetails(ticket);
        }
    }

    public static void validateCreatePassengerResponse(PassengerResponse passengerResponse) {
        assertEquals(DEFAULT_REQUEST_PASSENGER_FIRST_NAME, passengerResponse.getFirstName());
        assertEquals(DEFAULT_REQUEST_PASSENGER_LAST_NAME, passengerResponse.getLastName());
        assertEquals(DEFAULT_REQUEST_PASSENGER_AGE, passengerResponse.getAge());
        assertEquals(DEFAULT_REQUEST_PASSENGER_IS_PREMIUM, passengerResponse.getIsPremium());
    }

    public static void validateUpdatePassengerResponse(PassengerResponse passengerResponse) {
        assertEquals(UPDATE_REQUEST_PASSENGER_FIRST_NAME, passengerResponse.getFirstName());
        assertEquals(UPDATE_REQUEST_PASSENGER_LAST_NAME, passengerResponse.getLastName());
        assertEquals(UPDATE_REQUEST_PASSENGER_AGE, passengerResponse.getAge());
        assertEquals(UPDATE_REQUEST_PASSENGER_IS_PREMIUM, passengerResponse.getIsPremium());
    }
}
