package com.pada.learnproject.flight.service.command;

import com.pada.learnproject.flight.service.FlightType;

public record AddFlightCommand(Long airportId, Long flightId, FlightType flightType) {
}