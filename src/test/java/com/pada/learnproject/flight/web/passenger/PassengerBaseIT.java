package com.pada.learnproject.flight.web.passenger;

import static com.pada.learnproject.flight.constant.FlightTestValues.createDefaultTestFlight;
import static com.pada.learnproject.flight.constant.FlightTestValues.createSecondTestFlight;
import static com.pada.learnproject.flight.constant.FlightTestValues.createThirdTestFlight;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class PassengerBaseIT extends LearnprojectApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    protected Flight defaultFlight;
    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    @Transactional
    public void setUpTestData() {
        insertDefaultFlight();

        flightRepository.saveAndFlush(createSecondTestFlight());
        flightRepository.saveAndFlush(createThirdTestFlight());
    }

    private void insertDefaultFlight() {
        defaultFlight = createDefaultTestFlight();
        defaultFlight = flightRepository.saveAndFlush(defaultFlight);
    }

    @AfterEach
    public void deleteTestData() {
        flightRepository.deleteAll();
    }
}
