package com.pada.learnproject.flight.constant;

import static com.pada.learnproject.flight.domain.TicketClass.BUSINESS;
import static com.pada.learnproject.flight.domain.TicketClass.ECONOMY;
import static com.pada.learnproject.flight.domain.TicketClass.FIRST_CLASS;
import static com.pada.learnproject.flight.domain.TicketClass.PREMIUM_ECONOMY;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.domain.TicketClass;
import com.pada.learnproject.flight.service.dto.request.TicketRequest;

public interface TicketTestValues {

    TicketClass FIRST_TICKET_TICKET_CLASS = ECONOMY;
    Integer FIRST_TICKET_BASE_PRICE = 200;
    Integer FIRST_TICKET_LUGGAGE_FEE = 50;

    TicketClass SECOND_TICKET_TICKET_CLASS = BUSINESS;
    Integer SECOND_TICKET_BASE_PRICE = 500;
    Integer SECOND_TICKET_LUGGAGE_FEE = 0;

    TicketClass THIRD_TICKET_TICKET_CLASS = FIRST_CLASS;
    Integer THIRD_TICKET_BASE_PRICE = 1000;
    Integer THIRD_TICKET_LUGGAGE_FEE = 100;

    TicketClass DEFAULT_REQUEST_TICKET_TICKET_CLASS = PREMIUM_ECONOMY;
    Integer DEFAULT_REQUEST_TICKET_BASE_PRICE = 999;
    Integer DEFAULT_REQUEST_TICKET_LUGGAGE_FEE = 99;

    TicketClass UPDATE_REQUEST_TICKET_TICKET_CLASS = BUSINESS;
    Integer UPDATE_REQUEST_TICKET_BASE_PRICE = 999;
    Integer UPDATE_REQUEST_TICKET_LUGGAGE_FEE = 99;

    Integer INVALID_TICKET_BASE_PRICE = 1;
    Integer INVALID_TICKET_LUGGAGE_FEE = 1;


    Long NON_EXISTING_ID = -1L;

    static Ticket createDefaultTestTicket(Flight flight, Passenger passenger) {
        Ticket ticket =  Ticket.builder()
            .ticketClass(FIRST_TICKET_TICKET_CLASS)
            .basePrice(FIRST_TICKET_BASE_PRICE)
            .luggageFee(FIRST_TICKET_LUGGAGE_FEE)
            .build();
        bindTicketWithFlight(ticket, flight);
        bindTicketWithPassenger(ticket, passenger);
        return ticket;
    }

    static Ticket createSecondTestTicket(Flight flight, Passenger passenger) {
        Ticket ticket =  Ticket.builder()
            .ticketClass(SECOND_TICKET_TICKET_CLASS)
            .basePrice(SECOND_TICKET_BASE_PRICE)
            .luggageFee(SECOND_TICKET_LUGGAGE_FEE)
            .build();
        bindTicketWithFlight(ticket, flight);
        bindTicketWithPassenger(ticket, passenger);

        return ticket;
    }

    static Ticket createThirdTestTicket(Flight flight, Passenger passenger) {
        Ticket ticket =  Ticket.builder()
            .ticketClass(THIRD_TICKET_TICKET_CLASS)
            .basePrice(THIRD_TICKET_BASE_PRICE)
            .luggageFee(THIRD_TICKET_LUGGAGE_FEE)
            .build();
        bindTicketWithFlight(ticket,flight);
        bindTicketWithPassenger(ticket, passenger);

        return ticket;
    }

    static void bindTicketWithFlight(Ticket ticket, Flight flight) {
        ticket.setFlight(flight);
        flight.getTickets().add(ticket);
    }

    static void bindTicketWithPassenger(Ticket ticket, Passenger passenger) {
        ticket.setFlight(passenger);
        passenger.getTickets().add(ticket);
    }

    static TicketRequest createTicketRequest() {
        return new TicketRequest(DEFAULT_REQUEST_TICKET_TICKET_CLASS, DEFAULT_REQUEST_TICKET_BASE_PRICE,
            DEFAULT_REQUEST_TICKET_LUGGAGE_FEE);
    }

    static TicketRequest createUpdateTicketRequest() {
        return new TicketRequest(UPDATE_REQUEST_TICKET_TICKET_CLASS, UPDATE_REQUEST_TICKET_BASE_PRICE,
            UPDATE_REQUEST_TICKET_LUGGAGE_FEE);
    }
}
