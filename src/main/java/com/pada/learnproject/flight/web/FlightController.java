package com.pada.learnproject.flight.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pada.learnproject.flight.domain.criteria.FlightCriteria;
import com.pada.learnproject.flight.service.FlightService;
import com.pada.learnproject.flight.service.dto.response.FlightListWrapperResponse;
import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import com.pada.learnproject.flight.service.dto.response.FlightResponse;
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
@RequestMapping("/flights")
@Tag(name = "Flights Controller")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<FlightListWrapperResponse> getFlights(Pageable pageable, FlightCriteria flightCriteria) {
        var responseBody = flightService.findFlights(pageable, flightCriteria);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable(name = "id") Long id) {
        var responseBody = flightService.findById(id);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @PostMapping
    public ResponseEntity<FlightResponse> addFlight(@RequestBody FlightRequest flightRequest) {
        var responseBody = flightService.addFlight(flightRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponse> updateFlight(@PathVariable(name = "id") Long id,
        @RequestBody FlightRequest flightRequest) {
        var responseBody = flightService.updateFlight(id, flightRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FlightResponse> deleteFlight(@PathVariable(name = "id") Long id) {
        var responseBody = flightService.deleteFlight(id);
        return ResponseEntity.status(OK).body(responseBody);
    }
}
