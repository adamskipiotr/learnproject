package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.WeatherCondition;

public record AirportRequest(String name, WeatherCondition weatherCondition) {
}
