package com.pada.learnproject.flight.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pada.learnproject.flight.service.PassengerCriteria;
import com.pada.learnproject.flight.service.PassengerService;
import com.pada.learnproject.flight.service.dto.PassengerListWrapperResponse;
import com.pada.learnproject.flight.service.dto.PassengerRequest;
import com.pada.learnproject.flight.service.dto.PassengerResponse;
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
@RequestMapping("/passengers")
@Tag(name = "Passengers Controller")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping
    public ResponseEntity<PassengerListWrapperResponse> getPassenger(Pageable pageable, PassengerCriteria passengerCriteria) {
        var responseBody = passengerService.findPassengers(pageable, passengerCriteria);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponse> getPassengerById(@PathVariable(name = "id") Long id) {
        var responseBody = passengerService.findById(id);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @PostMapping
    public ResponseEntity<PassengerResponse> addPassenger(@RequestBody PassengerRequest passengerRequest) {
        var responseBody = passengerService.addPassenger(passengerRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerResponse> updatePassenger(@PathVariable(name = "id") Long id,
        @RequestBody PassengerRequest passengerRequest) {
        var responseBody = passengerService.updatePassenger(id, passengerRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PassengerResponse> deletePassenger(@PathVariable(name = "id") Long id) {
        var responseBody = passengerService.deletePassenger(id);
        return ResponseEntity.status(OK).body(responseBody);
    }
}
