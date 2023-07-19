package com.pada.learnproject.flight.service;

import static com.pada.learnproject.flight.repository.FlightRepository.Specs.flightStartBetween;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.repository.FlightRepository;
import com.pada.learnproject.flight.service.dto.FlightListResponse;
import com.pada.learnproject.flight.service.dto.FlightListWrapperResponse;
import com.pada.learnproject.flight.service.dto.FlightRequest;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import com.pada.learnproject.flight.service.mapper.FlightMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Transactional
    public FlightListWrapperResponse findFlights(Pageable pageable, FlightCriteria flightCriteria) {
        Specification<Flight> flightSpecification = createSpecification(flightCriteria);
        Page<Flight> flightPage = flightRepository.findAll(flightSpecification, pageable);

        List<FlightListResponse> data = flightPage
            .stream()
            .map(flightMapper::toListResponse)
            .toList();

        return new FlightListWrapperResponse(data);
    }

    private Specification<Flight> createSpecification(FlightCriteria filter) {
        Specification<Flight> specification = Specification.where(null);
        specification = flightStartBetween(specification, filter.getFlightStartLowerBoundary(),
            filter.getFlightStartUpperBoundary());

        return specification;

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
        flight = flightMapper.updateEntity(flight, flightRequest);
        return flightMapper.toResponse(flight);
    }

    @Transactional
    public FlightResponse deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(RuntimeException::new);
        flightRepository.deleteById(id);
        return flightMapper.toResponse(flight);
    }
}
