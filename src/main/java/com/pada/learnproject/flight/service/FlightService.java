package com.pada.learnproject.flight.service;

import static com.pada.learnproject.flight.repository.FlightRepository.Specs.flightStartBetween;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.FlightStatus;
import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.domain.criteria.FlightCriteria;
import com.pada.learnproject.flight.repository.FlightRepository;
import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import com.pada.learnproject.flight.service.dto.request.TicketRequest;
import com.pada.learnproject.flight.service.dto.response.FlightListResponse;
import com.pada.learnproject.flight.service.dto.response.FlightListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.FlightResponse;
import com.pada.learnproject.flight.service.mapper.FlightMapper;
import com.pada.learnproject.flight.service.validation.FlightValidator;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final FlightValidator flightValidator;
    private final TicketService ticketService;

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
        Flight flight = getFlightById(id);
        return flightMapper.toResponse(flight);
    }

    @Transactional
    public FlightResponse addFlight(@Valid FlightRequest flightRequest) {
        flightValidator.validate(flightRequest);
        Flight flight = flightMapper.toEntity(flightRequest);
        flight = flightRepository.save(flight);
        return flightMapper.toResponse(flight);
    }

    @Transactional
    public FlightResponse updateFlight(Long id, FlightRequest flightRequest) {
        flightValidator.validate(flightRequest);
        Flight flight = getFlightById(id);
        flight = flightMapper.updateEntity(flight, flightRequest);
        return flightMapper.toResponse(flight);
    }

    @Transactional
    public FlightResponse deleteFlight(Long id) {
        Flight flight = getFlightById(id);
        flightRepository.deleteById(id);
        return flightMapper.toResponse(flight);
    }

    public void toggleFlightStatus(Long id, FlightStatus flightStatus) {
        Flight flight = getFlightById(id);
        flight.toggleFlightStatus(flightStatus);
    }

    public void addTicketToFlight(Long id, TicketRequest ticketRequest) {
        Flight flight = getFlightById(id);
        Ticket ticket = ticketService.createTicket(ticketRequest);
        flight.addTicket(ticket);

    }

    private Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}
