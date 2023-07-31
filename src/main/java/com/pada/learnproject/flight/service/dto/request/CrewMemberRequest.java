package com.pada.learnproject.flight.service.dto.request;

import com.pada.learnproject.flight.domain.CrewMemberRank;


public record CrewMemberRequest(
    String firstName,
    String lastName,
    CrewMemberRank crewMemberRank,
    Integer age) {
}
