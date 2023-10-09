package com.pada.learnproject.flight.web;

import static com.pada.learnproject.flight.constant.AirportTestValues.createDefaultTestAirport;
import static com.pada.learnproject.flight.constant.AirportTestValues.createSecondTestAirport;
import static com.pada.learnproject.flight.constant.AirportTestValues.createThirdTestAirport;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createDefaultTestCrewMember;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createSecondTestCrewMember;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createThirdTestCrewMember;
import static com.pada.learnproject.flight.constant.FlightTestValues.createDefaultTestFlight;
import static com.pada.learnproject.flight.constant.FlightTestValues.createSecondTestFlight;
import static com.pada.learnproject.flight.constant.FlightTestValues.createThirdTestFlight;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createDefaultTestPassenger;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createSecondTestPassenger;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createThirdTestPassenger;
import static com.pada.learnproject.flight.constant.TicketTestValues.createDefaultTestTicket;
import static com.pada.learnproject.flight.constant.TicketTestValues.createSecondTestTicket;
import static com.pada.learnproject.flight.constant.TicketTestValues.createThirdTestTicket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.repository.AirportRepository;
import com.pada.learnproject.flight.repository.CrewMemberRepository;
import com.pada.learnproject.flight.repository.FlightRepository;
import com.pada.learnproject.flight.repository.PassengerRepository;
import com.pada.learnproject.flight.repository.TicketRepository;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightModuleBaseIT extends LearnprojectApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    protected Airport defaultAirport;
    protected Ticket defaultTicket;
    protected Passenger defaultPassenger;
    protected Flight defaultFlight;
    protected CrewMember defaultCrewMember;

    protected Airport secondAirport;
    protected Ticket secondTicket;
    protected Passenger secondPassenger;
    protected Flight secondFlight;
    protected CrewMember secondCrewMember;

    protected Airport thirdAirport;
    protected Ticket thirdTicket;
    protected Passenger thirdPassenger;
    protected Flight thirdFlight;
    protected CrewMember thirdCrewMember;
    @Autowired
    protected CrewMemberRepository crewMemberRepository;
    @Autowired
    protected TicketRepository ticketRepository;
    @Autowired
    protected PassengerRepository passengerRepository;
    @Autowired
    protected FlightRepository flightRepository;
    @Autowired
    protected AirportRepository airportRepository;

    @BeforeEach
    public void setUpTestData() {
        insertDefaultAirport();
        insertSecondAirport();
        insertThirdAirport();

        insertDefaultFlight();
        insertSecondFlight();
        insertThirdFlight();

        insertDefaultCrewMember();
        insertSecondCrewMember();
        insertThirdCrewMember();

        insertDefaultPassenger();
        insertSecondPassenger();
        insertThirdPassenger();

        insertDefaultTicket();
        insertSecondTicket();
        insertThirdTicket();
    }

    private void insertDefaultAirport() {
        defaultAirport = createDefaultTestAirport();
        defaultAirport = airportRepository.saveAndFlush(defaultAirport);
    }

    private void insertDefaultFlight() {
        defaultFlight = createDefaultTestFlight(defaultAirport, secondAirport, defaultCrewMember);
        defaultFlight = flightRepository.saveAndFlush(defaultFlight);
    }

    private void insertDefaultTicket() {
        defaultTicket = createDefaultTestTicket(defaultFlight, defaultPassenger);
        defaultTicket = ticketRepository.saveAndFlush(defaultTicket);
    }

    private void insertDefaultPassenger() {
        defaultPassenger = createDefaultTestPassenger();
        defaultPassenger = passengerRepository.saveAndFlush(defaultPassenger);
    }

    private void insertDefaultCrewMember() {
        defaultCrewMember = createDefaultTestCrewMember(defaultFlight);
        defaultCrewMember = crewMemberRepository.saveAndFlush(defaultCrewMember);
        defaultFlight = flightRepository.saveAndFlush(defaultFlight);
    }

    private void insertSecondAirport() {
        secondAirport = createSecondTestAirport();
        secondAirport = airportRepository.saveAndFlush(secondAirport);
    }

    private void insertSecondFlight() {
        secondFlight = createSecondTestFlight(secondAirport, thirdAirport, secondCrewMember);
        secondFlight = flightRepository.saveAndFlush(secondFlight);
    }

    private void insertSecondTicket() {
        secondTicket = createSecondTestTicket(secondFlight, secondPassenger);
        secondTicket = ticketRepository.saveAndFlush(secondTicket);
    }

    private void insertSecondPassenger() {
        secondPassenger = createSecondTestPassenger();
        secondPassenger = passengerRepository.saveAndFlush(secondPassenger);
    }

    private void insertSecondCrewMember() {
        secondCrewMember = createSecondTestCrewMember(secondFlight);
        secondCrewMember = crewMemberRepository.saveAndFlush(secondCrewMember);
    }


    private void insertThirdAirport() {
        thirdAirport = createThirdTestAirport();
        thirdAirport = airportRepository.saveAndFlush(thirdAirport);
    }

    private void insertThirdFlight() {
        thirdFlight = createThirdTestFlight(thirdAirport, defaultAirport, thirdCrewMember);
        thirdFlight = flightRepository.saveAndFlush(thirdFlight);
    }

    private void insertThirdTicket() {
        thirdTicket = createThirdTestTicket(thirdFlight, thirdPassenger);
        thirdTicket = ticketRepository.saveAndFlush(thirdTicket);
    }

    private void insertThirdPassenger() {
        thirdPassenger = createThirdTestPassenger();
        thirdPassenger = passengerRepository.saveAndFlush(thirdPassenger);
    }

    private void insertThirdCrewMember() {
        thirdCrewMember = createThirdTestCrewMember(thirdFlight);
        thirdCrewMember = crewMemberRepository.saveAndFlush(thirdCrewMember);
    }
    @AfterEach
    public void deleteTestData() {
        airportRepository.deleteAll();
        crewMemberRepository.deleteAll();
        flightRepository.deleteAll();
        passengerRepository.deleteAll();
        ticketRepository.deleteAll();
        airportRepository.deleteAll();
    }
}
