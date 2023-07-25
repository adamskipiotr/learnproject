package com.pada.learnproject.flight.web.ticket;

import static com.pada.learnproject.flight.constant.TicketTestValues.createDefaultTestTicket;
import static com.pada.learnproject.flight.constant.TicketTestValues.createSecondTestTicket;
import static com.pada.learnproject.flight.constant.TicketTestValues.createThirdTestTicket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.repository.TicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketBaseIT extends LearnprojectApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    protected Ticket defaultTicket;
    @Autowired
    private TicketRepository ticketRepository;

    @BeforeEach
    @Transactional
    public void setUpTestData() {
        insertDefaultPassenger();

        ticketRepository.saveAndFlush(createSecondTestTicket());
        ticketRepository.saveAndFlush(createThirdTestTicket());
    }

    private void insertDefaultPassenger() {
        defaultTicket = createDefaultTestTicket();
        defaultTicket = ticketRepository.saveAndFlush(defaultTicket);
    }

    @AfterEach
    public void deleteTestData() {
        ticketRepository.deleteAll();
    }
}
