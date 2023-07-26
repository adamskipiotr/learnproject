package com.pada.learnproject.flight.service.dto.request;

import com.pada.learnproject.flight.domain.WeatherCondition;

public record AirportRequest(String name, WeatherCondition weatherCondition) {
}
