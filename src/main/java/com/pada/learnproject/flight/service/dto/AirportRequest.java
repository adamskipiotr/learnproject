package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.WeatherCondition;

public record AirportRequest(String airportName, WeatherCondition weatherCondition) {
}
