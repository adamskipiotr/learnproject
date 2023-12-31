package com.pada.learnproject.flight.web.crewmember;

import static com.pada.learnproject.flight.constant.CrewMemberConstants.Urls.CREW_MEMBERS;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createCrewMemberRequest;
import static com.pada.learnproject.flight.validator.CrewMemberValidator.validateCreateCrewMemberResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.response.CrewMemberResponse;
import com.pada.learnproject.flight.web.FlightModuleBaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class CrewMemberControllerPostCrewMemberIT extends FlightModuleBaseIT {

    @Test
    void shouldReturnCreatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                post(CREW_MEMBERS)
                    .content(TestUtil.convertObjectToJsonBytes(createCrewMemberRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, CrewMemberResponse.class);
        validateCreateCrewMemberResponse(response);
    }
}
