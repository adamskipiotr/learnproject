package com.pada.learnproject.flight.validator;

import static com.pada.learnproject.flight.constant.CrewMemberTestValues.DEFAULT_CREATE_CREW_MEMBER_AGE;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.DEFAULT_CREATE_CREW_MEMBER_FIRSTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.DEFAULT_CREATE_CREW_MEMBER_LASTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.DEFAULT_CREATE_CREW_MEMBER_RANK;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_AGE;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_FIRSTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_LASTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_RANK;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.UPDATE_CREATE_CREW_MEMBER_AGE;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.UPDATE_CREATE_CREW_MEMBER_FIRSTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.UPDATE_CREATE_CREW_MEMBER_LASTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.UPDATE_CREATE_CREW_MEMBER_RANK;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.flight.service.dto.CrewMemberListWrapperResponse;
import com.pada.learnproject.flight.service.dto.CrewMemberResponse;
import org.springframework.stereotype.Component;

@Component
public class CrewMemberValidator {

    public static void validateCrewMemberListWrapperWithWithThreeElementsInList(
        CrewMemberListWrapperResponse response) {
        var flightListResponseList = response.crewMembers();
        assertEquals(3, flightListResponseList.size());
    }

    public static void validateCrewMemberListWrapperWithCrewMemberListResponse(CrewMemberListWrapperResponse response) {
        var flightListResponseList = response.crewMembers();
        assertEquals(1, flightListResponseList.size());

        var flightListResponse = flightListResponseList.get(0);
        assertEquals(FIRST_CREW_MEMBER_FIRSTNAME, flightListResponse.firstName());
        assertEquals(FIRST_CREW_MEMBER_LASTNAME, flightListResponse.lastName());
    }

    public static void validateEmptyCrewMemberListWrapperResponse(CrewMemberListWrapperResponse response) {
        var flightListResponseList = response.crewMembers();
        assertTrue(flightListResponseList.isEmpty());
    }

    public static void validateCrewMemberResponseDetails(CrewMemberResponse flightResponse) {
        assertEquals(FIRST_CREW_MEMBER_FIRSTNAME, flightResponse.firstName());
        assertEquals(FIRST_CREW_MEMBER_LASTNAME, flightResponse.lastName());
        assertEquals(FIRST_CREW_MEMBER_AGE, flightResponse.age());
        assertEquals(FIRST_CREW_MEMBER_RANK, flightResponse.crewMemberRank());
    }

    public static void validateCreateCrewMemberResponse(CrewMemberResponse flightResponse) {
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_FIRSTNAME, flightResponse.firstName());
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_LASTNAME, flightResponse.lastName());
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_AGE, flightResponse.age());
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_RANK, flightResponse.crewMemberRank());
    }

    public static void validateUpdateCrewMemberResponse(CrewMemberResponse flightResponse) {
        assertEquals(UPDATE_CREATE_CREW_MEMBER_FIRSTNAME, flightResponse.firstName());
        assertEquals(UPDATE_CREATE_CREW_MEMBER_LASTNAME, flightResponse.lastName());
        assertEquals(UPDATE_CREATE_CREW_MEMBER_AGE, flightResponse.age());
        assertEquals(UPDATE_CREATE_CREW_MEMBER_RANK, flightResponse.crewMemberRank());
    }
}
