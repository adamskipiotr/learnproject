package com.pada.learnproject.flight.service;

import com.pada.learnproject.example.service.dto.response.ExampleListWrapperResponse;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.repository.FlightRepository;
import com.pada.learnproject.flight.service.dto.FlightRequest;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import com.pada.learnproject.flight.service.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Transactional
    public ExampleListWrapperResponse findFlights(Pageable pageable, FlightCriteria flightCriteria) {
        return null;
    }

    @Transactional
    public FlightResponse findById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(RuntimeException::new);
        return flightMapper.toResponse(flight);
    }

    @Transactional
    public FlightResponse addFlight(FlightRequest flightRequest) {
        Flight flight = flightMapper.toEntity(flightRequest);
        flight = flightRepository.save(flight);
        return flightMapper.toResponse(flight);
    }


    @Transactional
    public FlightResponse updateFlight(Long id, FlightRequest flightRequest) {
        Flight flight = flightRepository.findById(id).orElseThrow(RuntimeException::new);
        flightMapper.updateEntity(flight, flightRequest);
        return flightMapper.toResponse(flight);
    }
}
