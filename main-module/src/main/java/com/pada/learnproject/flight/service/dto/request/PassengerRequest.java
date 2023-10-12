package com.pada.learnproject.flight.service.dto.request;

public record PassengerRequest(String firstName, String lastName, Integer age, Boolean isPremium) {
}
