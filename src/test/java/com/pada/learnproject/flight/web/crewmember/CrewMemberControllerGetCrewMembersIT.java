package com.pada.learnproject.flight.web.crewmember;

import static com.pada.learnproject.common.util.FilterUtil.filterBy;
import static com.pada.learnproject.flight.constant.CrewMemberConstants.FilteringFields.AGE;
import static com.pada.learnproject.flight.constant.CrewMemberConstants.FilteringFields.FIRSTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberConstants.FilteringFields.LASTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberConstants.Urls.CREW_MEMBERS;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_AGE;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_FIRSTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.FIRST_CREW_MEMBER_LASTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.INVALID_CREW_MEMBER_AGE;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.INVALID_CREW_MEMBER_FIRSTNAME;
import static com.pada.learnproject.flight.constant.CrewMemberTestValues.INVALID_CREW_MEMBER_LASTNAME;
import static com.pada.learnproject.flight.validator.CrewMemberValidator.validateCrewMemberListWrapperWithCrewMemberListResponse;
import static com.pada.learnproject.flight.validator.CrewMemberValidator.validateCrewMemberListWrapperWithWithThreeElementsInList;
import static com.pada.learnproject.flight.validator.CrewMemberValidator.validateEmptyCrewMemberListWrapperResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.pada.learnproject.flight.service.dto.response.CrewMemberListWrapperResponse;
import org.junit.jupiter.api.Test;

class CrewMemberControllerGetCrewMembersIT extends CrewMemberBaseIT {

    @Test
    void shouldReturnResponseWithThreeElementInListWhenQueryWithoutFilters() throws Exception {
        var result = mockMvc.perform(get(CREW_MEMBERS))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, CrewMemberListWrapperResponse.class);
        validateCrewMemberListWrapperWithWithThreeElementsInList(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenProvidedFilterCriteriaMatchingDefaultEntity() throws
        Exception {
        var result = mockMvc.perform(get(CREW_MEMBERS + defaultCrewMemberFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, CrewMemberListWrapperResponse.class);
        validateCrewMemberListWrapperWithCrewMemberListResponse(response);
    }

    @Test
    void shouldReturnResponseWithEmptyListWhenNoMatchingFilterCriteriaProvided() throws Exception {
        var result = mockMvc.perform(get(CREW_MEMBERS + nonMatchingFilters()))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, CrewMemberListWrapperResponse.class);
        validateEmptyCrewMemberListWrapperResponse(response);
    }

    private String defaultCrewMemberFilters() {
        return filterBy()
            .param(FIRSTNAME, FIRST_CREW_MEMBER_FIRSTNAME)
            .param(LASTNAME, FIRST_CREW_MEMBER_LASTNAME)
            .param(AGE, FIRST_CREW_MEMBER_AGE)
            .toQueryString();
    }

    private String nonMatchingFilters() {
        return filterBy()
            .param(FIRSTNAME, INVALID_CREW_MEMBER_FIRSTNAME)
            .param(LASTNAME, INVALID_CREW_MEMBER_LASTNAME)
            .param(AGE, INVALID_CREW_MEMBER_AGE)
            .toQueryString();
    }
}
