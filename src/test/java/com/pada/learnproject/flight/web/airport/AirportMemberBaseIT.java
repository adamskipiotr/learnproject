package com.pada.learnproject.flight.web.airport;

import static com.pada.learnproject.flight.constant.AirportTestValues.createDefaultTestAirport;
import static com.pada.learnproject.flight.constant.AirportTestValues.createSecondTestAirport;
import static com.pada.learnproject.flight.constant.AirportTestValues.createThirdTestAirport;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createDefaultTestCrewMember;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createSecondTestCrewMember;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createThirdTestCrewMember;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.repository.AirportRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class AirportMemberBaseIT extends LearnprojectApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    protected Airport defaultAirport;
    @Autowired
    private AirportRepository airportRepository;

    @BeforeEach
    @Transactional
    public void setUpTestData() {
        insertDefaultAirport();

        airportRepository.saveAndFlush(createSecondTestAirport());
        airportRepository.saveAndFlush(createThirdTestAirport());
    }

    private void insertDefaultAirport() {
        defaultAirport = createDefaultTestAirport();
        defaultAirport = airportRepository.saveAndFlush(defaultAirport);
    }

    @AfterEach
    public void deleteTestData() {
        airportRepository.deleteAll();
    }
}
