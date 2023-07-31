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

import com.pada.learnproject.flight.service.dto.response.CrewMemberListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.CrewMemberResponse;
import org.springframework.stereotype.Component;

@Component
public class CrewMemberValidator {

    public static void validateCrewMemberListWrapperWithWithThreeElementsInList(
        CrewMemberListWrapperResponse response) {
        var crewMemberResponseList = response.crewMembers();
        assertEquals(3, crewMemberResponseList.size());
    }

    public static void validateCrewMemberListWrapperWithCrewMemberListResponse(CrewMemberListWrapperResponse response) {
        var crewMemberResponseList = response.crewMembers();
        assertEquals(1, crewMemberResponseList.size());

        var crewMemberListResponse = crewMemberResponseList.get(0);
        assertEquals(FIRST_CREW_MEMBER_FIRSTNAME, crewMemberListResponse.firstName());
        assertEquals(FIRST_CREW_MEMBER_LASTNAME, crewMemberListResponse.lastName());
    }

    public static void validateEmptyCrewMemberListWrapperResponse(CrewMemberListWrapperResponse response) {
        var crewMemberResponseList = response.crewMembers();
        assertTrue(crewMemberResponseList.isEmpty());
    }

    public static void validateCrewMemberResponseDetails(CrewMemberResponse crewMemberResponse) {
        assertEquals(FIRST_CREW_MEMBER_FIRSTNAME, crewMemberResponse.getFirstName());
        assertEquals(FIRST_CREW_MEMBER_LASTNAME, crewMemberResponse.getLastName());
        assertEquals(FIRST_CREW_MEMBER_AGE, crewMemberResponse.getAge());
        assertEquals(FIRST_CREW_MEMBER_RANK, crewMemberResponse.getCrewMemberRank());
    }

    public static void validateCreateCrewMemberResponse(CrewMemberResponse crewMemberResponse) {
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_FIRSTNAME, crewMemberResponse.getFirstName());
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_LASTNAME, crewMemberResponse.getLastName());
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_AGE, crewMemberResponse.getAge());
        assertEquals(DEFAULT_CREATE_CREW_MEMBER_RANK, crewMemberResponse.getCrewMemberRank());
    }

    public static void validateUpdateCrewMemberResponse(CrewMemberResponse crewMemberResponse) {
        assertEquals(UPDATE_CREATE_CREW_MEMBER_FIRSTNAME, crewMemberResponse.getFirstName());
        assertEquals(UPDATE_CREATE_CREW_MEMBER_LASTNAME, crewMemberResponse.getLastName());
        assertEquals(UPDATE_CREATE_CREW_MEMBER_AGE, crewMemberResponse.getAge());
        assertEquals(UPDATE_CREATE_CREW_MEMBER_RANK, crewMemberResponse.getCrewMemberRank());
    }
}
