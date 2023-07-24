package com.pada.learnproject.flight.web.crewmember;

import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createDefaultTestCrewMember;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createSecondTestCrewMember;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createThirdTestCrewMember;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pada.learnproject.LearnprojectApplicationTests;
import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.repository.CrewMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class CrewMemberBaseIT extends LearnprojectApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    protected CrewMember defaultCrewMember;
    @Autowired
    private CrewMemberRepository crewMemberRepository;

    @BeforeEach
    @Transactional
    public void setUpTestData() {
        insertDefaultCrewMember();

        crewMemberRepository.saveAndFlush(createSecondTestCrewMember());
        crewMemberRepository.saveAndFlush(createThirdTestCrewMember());
    }

    private void insertDefaultCrewMember() {
        defaultCrewMember = createDefaultTestCrewMember();
        defaultCrewMember = crewMemberRepository.saveAndFlush(defaultCrewMember);
    }

    @AfterEach
    public void deleteTestData() {
        crewMemberRepository.deleteAll();
    }
}
