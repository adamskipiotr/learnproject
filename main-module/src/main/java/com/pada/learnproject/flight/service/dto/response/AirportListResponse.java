package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.WeatherCondition;

public record AirportListResponse(
    String name,
    WeatherCondition weatherCondition
) {
}
