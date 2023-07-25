package com.pada.learnproject.flight.service.dto;

public record PassengerRequest(String firstName, String lastName, Integer age, Boolean isPremium) {
}
