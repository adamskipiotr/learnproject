package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.CrewMemberRank;

public record AirportListResponse(
    String firstName,
    String lastName,
    CrewMemberRank crewMemberRank,
    Integer age) {
}
