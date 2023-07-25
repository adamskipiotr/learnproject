package com.pada.learnproject.flight.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pada.learnproject.flight.service.TicketCriteria;
import com.pada.learnproject.flight.service.TicketService;
import com.pada.learnproject.flight.service.dto.TicketListWrapperResponse;
import com.pada.learnproject.flight.service.dto.TicketRequest;
import com.pada.learnproject.flight.service.dto.TicketResponse;
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
@RequestMapping("/tickets")
@Tag(name = "TIckets Controller")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<TicketListWrapperResponse> getTicket(Pageable pageable, TicketCriteria ticketCriteria) {
        var responseBody = ticketService.findTickets(pageable, ticketCriteria);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable(name = "id") Long id) {
        var responseBody = ticketService.findById(id);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @PostMapping
    public ResponseEntity<TicketResponse> addTicket(@RequestBody TicketRequest ticketRequest) {
        var responseBody = ticketService.addTicket(ticketRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponse> updateTicket(@PathVariable(name = "id") Long id,
        @RequestBody TicketRequest ticketRequest) {
        var responseBody = ticketService.updateTicket(id, ticketRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TicketResponse> deleteTicket(@PathVariable(name = "id") Long id) {
        var responseBody = ticketService.deleteTicket(id);
        return ResponseEntity.status(OK).body(responseBody);
    }
}
