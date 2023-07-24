package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.CrewMemberRank;

public record CrewMemberResponse(
    String firstName,
    String lastName,
    CrewMemberRank crewMemberRank,
    Integer age
) {
}
