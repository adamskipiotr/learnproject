package com.pada.learnproject.flight.web.crewmember;


import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.CrewMemberConstants.Urls.createUrlWithEntityId;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.NON_EXISTING_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.flight.service.dto.CrewMemberResponse;
import com.pada.learnproject.flight.validator.CrewMemberValidator;
import org.junit.jupiter.api.Test;

class CrewMemberControllerGetCrewMemberIT extends CrewMemberBaseIT {


    @Test
    void shouldReturnDefaultCrewMemberWhenSearchingWithValidId() throws Exception {
        var result = mockMvc.perform(
                get(createUrlWithEntityId(defaultCrewMember.getId())))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, CrewMemberResponse.class);
        CrewMemberValidator.validateCrewMemberResponseDetails(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenWhenNonExistingIdProvided() throws Exception {
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
