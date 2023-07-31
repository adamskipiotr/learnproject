package com.pada.learnproject.flight.constant;

import static com.pada.learnproject.flight.domain.CrewMemberRank.CAPTAIN;
import static com.pada.learnproject.flight.domain.CrewMemberRank.FIRST_OFFICER;
import static com.pada.learnproject.flight.domain.CrewMemberRank.SENIOR_FIRST_OFFICER;

import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.CrewMemberRank;
import com.pada.learnproject.flight.service.dto.request.CrewMemberRequest;

public interface CrewMemberTestValues {

    String FIRST_CREW_MEMBER_FIRSTNAME = "Firstname 1";
    String FIRST_CREW_MEMBER_LASTNAME = "Firstname 1";
    Integer FIRST_CREW_MEMBER_AGE = 30;
    CrewMemberRank FIRST_CREW_MEMBER_RANK = FIRST_OFFICER;

    String SECOND_CREW_MEMBER_FIRSTNAME = "Firstname 2";
    String SECOND_CREW_MEMBER_LASTNAME = "Lastname 2";
    Integer SECOND_CREW_MEMBER_AGE = 28;
    CrewMemberRank SECOND_CREW_MEMBER_RANK = SENIOR_FIRST_OFFICER;

    String THIRD_CREW_MEMBER_FIRSTNAME = "Firstname 3";
    String THIRD_CREW_MEMBER_LASTNAME = "Lastname 3";
    Integer THIRD_CREW_MEMBER_AGE = 35;
    CrewMemberRank THIRD_CREW_MEMBER_RANK = CAPTAIN;

    String DEFAULT_CREATE_CREW_MEMBER_FIRSTNAME = "Create crew member firstname";
    String DEFAULT_CREATE_CREW_MEMBER_LASTNAME = "Create crew member lastname";
    Integer DEFAULT_CREATE_CREW_MEMBER_AGE = 20;
    CrewMemberRank DEFAULT_CREATE_CREW_MEMBER_RANK = FIRST_OFFICER;

    String UPDATE_CREATE_CREW_MEMBER_FIRSTNAME = "Update crew member firstname";
    String UPDATE_CREATE_CREW_MEMBER_LASTNAME = "Update crew member lastname";
    Integer UPDATE_CREATE_CREW_MEMBER_AGE = 29;
    CrewMemberRank UPDATE_CREATE_CREW_MEMBER_RANK = CAPTAIN;

    String INVALID_CREW_MEMBER_FIRSTNAME = "Invalid Firstname";
    String INVALID_CREW_MEMBER_LASTNAME = "Invalid Lastname";
    Integer INVALID_CREW_MEMBER_AGE = 9999;


    Long NON_EXISTING_ID = -1L;

    static CrewMember createDefaultTestCrewMember() {
        return CrewMember.builder()
            .firstName(FIRST_CREW_MEMBER_FIRSTNAME)
            .lastName(FIRST_CREW_MEMBER_LASTNAME)
            .age(FIRST_CREW_MEMBER_AGE)
            .crewMemberRank(FIRST_CREW_MEMBER_RANK)
            .build();
    }

    static CrewMember createSecondTestCrewMember() {
        return CrewMember.builder()
            .firstName(SECOND_CREW_MEMBER_FIRSTNAME)
            .lastName(SECOND_CREW_MEMBER_LASTNAME)
            .age(SECOND_CREW_MEMBER_AGE)
            .crewMemberRank(SECOND_CREW_MEMBER_RANK)
            .build();
    }

    static CrewMember createThirdTestCrewMember() {
        return CrewMember.builder()
            .firstName(THIRD_CREW_MEMBER_FIRSTNAME)
            .lastName(THIRD_CREW_MEMBER_LASTNAME)
            .age(THIRD_CREW_MEMBER_AGE)
            .crewMemberRank(THIRD_CREW_MEMBER_RANK)
            .build();
    }

    static CrewMemberRequest createCrewMemberRequest() {
        return new CrewMemberRequest(DEFAULT_CREATE_CREW_MEMBER_FIRSTNAME, DEFAULT_CREATE_CREW_MEMBER_LASTNAME,
            DEFAULT_CREATE_CREW_MEMBER_RANK, DEFAULT_CREATE_CREW_MEMBER_AGE);
    }

    static CrewMemberRequest createUpdateCrewMemberRequest() {
        return new CrewMemberRequest(UPDATE_CREATE_CREW_MEMBER_FIRSTNAME, UPDATE_CREATE_CREW_MEMBER_LASTNAME,
            UPDATE_CREATE_CREW_MEMBER_RANK, UPDATE_CREATE_CREW_MEMBER_AGE);
    }
}
