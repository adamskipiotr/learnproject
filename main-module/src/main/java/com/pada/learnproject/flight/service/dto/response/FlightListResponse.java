package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.FlightStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightListResponse {
    private String flightName;
    private LocalDateTime flightStart;
    private LocalDateTime flightEnd;
    private FlightStatus flightStatus;
    private Integer maxPassengerCount;
    private Integer currentPassengerCount;
}