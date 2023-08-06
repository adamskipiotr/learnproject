package com.pada.learnproject.flight.web.crewmember;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.CrewMemberConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.NON_EXISTING_ID;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.createUpdateCrewMemberRequest;
import static com.pada.learnproject.flight.validator.CrewMemberValidator.validateUpdateCrewMemberResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.common.util.TestUtil;
import com.pada.learnproject.flight.service.dto.response.CrewMemberResponse;
import com.pada.learnproject.flight.web.FlightModuleBaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class CrewMemberControllerPutCrewMemberIT extends FlightModuleBaseIT {

    @Test
    void shouldReturnUpdatedEntityWhenCorrectRequestProvided() throws Exception {
        var result = mockMvc.perform(
                put(createUrlWithEntityId(defaultCrewMember.getId()))
                    .content(TestUtil.convertObjectToJsonBytes(createUpdateCrewMemberRequest()))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, CrewMemberResponse.class);
        validateUpdateCrewMemberResponse(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenNonExistingIdProvided() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(NON_EXISTING_ID)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }
}
