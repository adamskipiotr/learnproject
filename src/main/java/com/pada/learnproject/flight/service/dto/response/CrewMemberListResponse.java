package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.CrewMemberRank;

public record CrewMemberListResponse(
    String firstName,
    String lastName,
    CrewMemberRank crewMemberRank,
    Integer age) {
}
