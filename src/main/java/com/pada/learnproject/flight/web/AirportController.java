package com.pada.learnproject.flight.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pada.learnproject.flight.domain.criteria.AirportCriteria;
import com.pada.learnproject.flight.service.command.AddFlightCommand;
import com.pada.learnproject.flight.service.AirportService;
import com.pada.learnproject.flight.service.FlightType;
import com.pada.learnproject.flight.service.dto.request.AirportRequest;
import com.pada.learnproject.flight.service.dto.response.AirportListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.AirportResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airports")
@Tag(name = "Airports Controller")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<AirportListWrapperResponse> getAirports(Pageable pageable, AirportCriteria airportCriteria) {
        var responseBody = airportService.findAirports(pageable, airportCriteria);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable(name = "id") Long id) {
        var responseBody = airportService.findById(id);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @PostMapping
    public ResponseEntity<AirportResponse> addAirport(@RequestBody AirportRequest airportRequest) {
        var responseBody = airportService.addAirport(airportRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(@PathVariable(name = "id") Long id,
        @RequestBody AirportRequest airportRequest) {
        var responseBody = airportService.updateAirport(id, airportRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @PostMapping("/{airportId}/flights/{flightId}/{relationshipType}")
    public ResponseEntity<AirportResponse> addFlightToAirport(@PathVariable Long airportId,
        @PathVariable Long flightId, @PathVariable FlightType flightType) {
         airportService.addFlight(new AddFlightCommand(airportId, flightId, flightType));
        return ResponseEntity.status(CREATED).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AirportResponse> deleteAirport(@PathVariable(name = "id") Long id) {
        var responseBody = airportService.deleteAirport(id);
        return ResponseEntity.status(OK).body(responseBody);
    }
}
