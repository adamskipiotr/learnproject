package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.CrewMemberRank;

public record PassengerListResponse(
    String firstName,
    String lastName,
    CrewMemberRank crewMemberRank,
    Integer age) {
}
