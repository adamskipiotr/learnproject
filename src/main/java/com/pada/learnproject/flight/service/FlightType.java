package com.pada.learnproject.flight.service;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.Flight;

public enum FlightType {
    ARRIVAL {
        @Override
        public void addFlight(Airport airport, Flight flight) {
            airport.addArrivalFlight(flight);
        }
    },
    DEPARTURE {
        @Override
        public void addFlight(Airport airport, Flight flight) {
            airport.addDepartureFlight(flight);
        }
    };

    public abstract void addFlight(Airport airport, Flight flight);
}
