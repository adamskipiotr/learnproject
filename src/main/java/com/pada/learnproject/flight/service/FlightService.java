package com.pada.learnproject.flight.service;

import static com.pada.learnproject.flight.repository.FlightRepository.Specs.flightStartBetween;

import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.FlightStatus;
import com.pada.learnproject.flight.domain.criteria.FlightCriteria;
import com.pada.learnproject.flight.repository.FlightRepository;
import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import com.pada.learnproject.flight.service.dto.response.FlightListResponse;
import com.pada.learnproject.flight.service.dto.response.FlightListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.FlightResponse;
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
    private final CrewMemberService crewMemberService;

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
    public FlightResponse getById(Long id) {
        Flight flight = findById(id);
        return flightMapper.toResponse(flight);
    }

    @Transactional
    public Flight findById(Long id) {
        return flightRepository.findById(id).orElseThrow(RuntimeException::new);
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

    @Transactional
    public FlightResponse changeFlightStatus(Long id, FlightStatus flightStatus){
        Flight flight = flightRepository.findById(id).orElseThrow(RuntimeException::new);
        flight.changeFlightStatus(flightStatus);
        return flightMapper.toResponse(flight);
    }

    public void addCrewMember(Long flightId, Long crewMemberId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(RuntimeException::new);
        CrewMember crewMember = crewMemberService.findById(crewMemberId);
        flight.addCrewMember(crewMember);

    }
}
