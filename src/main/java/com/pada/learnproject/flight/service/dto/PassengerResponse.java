package com.pada.learnproject.flight.service.dto;

public record PassengerResponse(
    String firstName,
    String lastName,
    Integer age,
    Boolean isPremium
) {
}
