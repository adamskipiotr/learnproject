package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.WeatherCondition;

public record AirportResponse(
    String name,
    WeatherCondition weatherCondition
) {
}
