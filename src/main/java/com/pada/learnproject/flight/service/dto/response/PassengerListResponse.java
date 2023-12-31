package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.CrewMemberRank;

public record PassengerListResponse(
    String firstName,
    String lastName,
    CrewMemberRank crewMemberRank,
    Integer age) {
}
