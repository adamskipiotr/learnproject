package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.FlightStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private String flightName;
    private LocalDateTime flightStart;
    private LocalDateTime flightEnd;
    private FlightStatus flightStatus;
    private List<CrewMemberResponse> crewMembers;
    private AirportResponse startAirport;
    private AirportResponse endAirport;
}