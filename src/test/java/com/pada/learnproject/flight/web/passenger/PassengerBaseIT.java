package com.pada.learnproject.flight.web.passenger;

import static com.pada.learnproject.flight.constant.PassengerTestValues.createDefaultTestPassenger;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createSecondTestPassenger;
import static com.pada.learnproject.flight.constant.PassengerTestValues.createThirdTestPassenger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.repository.PassengerRepository;
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
    protected Passenger defaultPassenger;
    @Autowired
    private PassengerRepository passengerRepository;

    @BeforeEach
    @Transactional
    public void setUpTestData() {
        insertDefaultPassenger();

        passengerRepository.saveAndFlush(createSecondTestPassenger());
        passengerRepository.saveAndFlush(createThirdTestPassenger());
    }

    private void insertDefaultPassenger() {
        defaultPassenger = createDefaultTestPassenger();
        defaultPassenger = passengerRepository.saveAndFlush(defaultPassenger);
    }

    @AfterEach
    public void deleteTestData() {
        passengerRepository.deleteAll();
    }
}
