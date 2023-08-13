package com.pada.learnproject.flight.web.flight;

import static com.pada.learnproject.common.validator.ErrorResponseValidator.validateErrorResponse;
import static com.pada.learnproject.flight.constant.FlightConstants.Urls.createUrlWithEntityIdAndStatus;
import static com.pada.learnproject.flight.domain.FlightStatus.CANCELLED;
import static com.pada.learnproject.flight.domain.FlightStatus.FINISHED;
import static com.pada.learnproject.flight.domain.FlightStatus.ONGOING;
import static com.pada.learnproject.flight.domain.FlightStatus.SCHEDULED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import com.pada.learnproject.common.infractructure.ErrorResponse;
import com.pada.learnproject.flight.domain.FlightStatus;
import com.pada.learnproject.flight.web.FlightModuleBaseIT;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.http.MediaType;

class FlightControllerPutUpdateFlightStatusIT extends FlightModuleBaseIT {

    @Test
    void shouldThrowRuntimeExceptionWhenChangingScheduledToOngoingWithTooFewCrewMembers() throws Exception {
        var result = mockMvc.perform(
                patch(createUrlWithEntityIdAndStatus(defaultFlight.getId(), ONGOING))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }

    @Test
    void shouldThrowExceptionWhenFlightNameIsNull() throws Exception {
        defaultFlight.setFlightName(null);
        performPatchAndAssertErrorResponse();
    }

    @Test
    void shouldThrowExceptionWhenFlightStatusIsNull() throws Exception {
        defaultFlight.setFlightStatus(null);
        performPatchAndAssertErrorResponse();
    }

    @Test
    void shouldThrowExceptionWhenFlightEndIsNull() throws Exception {
        defaultFlight.setFlightEnd(null);
        performPatchAndAssertErrorResponse();
    }

    @Test
    void shouldThrowExceptionWhenMaxPassengerCountIsNull() throws Exception {
        defaultFlight.setMaxPassengerCount(null);
        performPatchAndAssertErrorResponse();
    }

    @Test
    void shouldThrowExceptionWhenStartAirportIsNull() throws Exception {
        defaultFlight.setStartAirport(null);
        performPatchAndAssertErrorResponse();
    }

    @Test
    void shouldThrowExceptionWhenEndAirportIsNull() throws Exception {
        defaultFlight.setEndAirport(null);
        performPatchAndAssertErrorResponse();
    }

    @Test
    void shouldThrowRuntimeExceptionWhenChangingScheduledToFinished() throws Exception {
        var result = mockMvc.perform(
                patch(createUrlWithEntityIdAndStatus(defaultFlight.getId(), FINISHED))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenChangingOngoingToCancelled() throws Exception {
        defaultFlight.setFlightStatus(ONGOING);
        flightRepository.save(defaultFlight);
        var result = mockMvc.perform(
                patch(createUrlWithEntityIdAndStatus(defaultFlight.getId(), CANCELLED))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }

    @ParameterizedTest
    @EnumSource(value = FlightStatus.class, names = "OTHER", mode = EnumSource.Mode.EXCLUDE)
    void shouldThrowRuntimeExceptionWhenChangingNotOtherStatusToScheduled(FlightStatus flightStatus) throws Exception {
        defaultFlight.setFlightStatus(flightStatus);
        flightRepository.save(defaultFlight);
        var result = mockMvc.perform(
                patch(createUrlWithEntityIdAndStatus(defaultFlight.getId(), SCHEDULED))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenNonExistingIdProvided() throws Exception {
        var result = mockMvc.perform(
                patch(createUrlWithEntityIdAndStatus(defaultFlight.getId(), ONGOING))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }

    private void performPatchAndAssertErrorResponse() throws Exception {
        var result = mockMvc.perform(
                patch(createUrlWithEntityIdAndStatus(defaultFlight.getId(), FINISHED))
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();

        var response = objectMapper.readValue(result, ErrorResponse.class);
        validateErrorResponse(response);
    }
}
