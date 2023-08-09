package com.pada.learnproject.flight.service.validation;

import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import org.springframework.stereotype.Service;

@Service
public class FlightValidator {

    public void validate(FlightRequest flightRequest) {
        validateFlightEndAfterFlightStart(flightRequest);
    }

    private void validateFlightEndAfterFlightStart(FlightRequest flightRequest) {
        if (flightRequest.flightEnd().isBefore(flightRequest.flightStart())) {
            throw new IllegalArgumentException("Flight's end date cannot be before flight's start date");
        }
    }
}
