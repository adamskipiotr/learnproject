package com.pada.learnproject.flight.service.dto.response;

public record PassengerResponse(
    String firstName,
    String lastName,
    Integer age,
    Boolean isPremium
) {
}
