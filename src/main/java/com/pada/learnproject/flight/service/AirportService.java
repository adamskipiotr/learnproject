package com.pada.learnproject.flight.service;

import static com.pada.learnproject.flight.repository.AirportRepository.Specs.airportByNameLike;
import static com.pada.learnproject.flight.repository.AirportRepository.Specs.byWeatherCondition;
import static com.pada.learnproject.flight.service.FlightType.ARRIVAL;
import static com.pada.learnproject.flight.service.FlightType.DEPARTURE;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.Airport_;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.criteria.AirportCriteria;
import com.pada.learnproject.flight.repository.AirportRepository;
import com.pada.learnproject.flight.service.dto.request.AirportRequest;
import com.pada.learnproject.flight.service.dto.response.AirportListResponse;
import com.pada.learnproject.flight.service.dto.response.AirportListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.AirportResponse;
import com.pada.learnproject.flight.service.mapper.AirportMapper;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;
    private final FlightService flightService;

    public AirportListWrapperResponse findAirports(Pageable pageable, AirportCriteria airportCriteria) {
        Specification<Airport> airportSpecification = createSpecification(airportCriteria);
        Page<Airport> airportPage = airportRepository.findAll(airportSpecification, pageable);
        List<AirportListResponse> data = airportPage
            .stream()
            .map(airportMapper::toListResponse)
            .toList();

        return new AirportListWrapperResponse(data);
    }

    private Specification<Airport> createSpecification(AirportCriteria filter) {
        Specification<Airport> specification = Specification.where(null);
        specification = airportByNameLike(specification, filter.getName(), Airport_.name);
        specification = byWeatherCondition(specification, filter.getWeatherCondition());
        return specification;
    }

    public AirportResponse findById(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow(RuntimeException::new);
        return airportMapper.toResponse(airport);
    }

    public AirportResponse addAirport(AirportRequest airportRequest) {
        Airport airport = airportMapper.toEntity(airportRequest);
        airport = airportRepository.save(airport);
        return airportMapper.toResponse(airport);
    }

    public AirportResponse updateAirport(Long id, AirportRequest airportRequest) {
        Airport airport = airportRepository.findById(id).orElseThrow(RuntimeException::new);
        airport = airportMapper.updateEntity(airport, airportRequest);
        return airportMapper.toResponse(airport);
    }


    public AirportResponse deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow(RuntimeException::new);
        airportRepository.deleteById(id);
        return airportMapper.toResponse(airport);
    }

    public void addFlight(Long airportId, Long flightId, FlightType flightType) {
        Airport airport = airportRepository.findById(airportId).orElseThrow(RuntimeException::new);
        Flight flight = flightService.findById(flightId);
        airport.addFlight(flight,flightType);
    }


}
