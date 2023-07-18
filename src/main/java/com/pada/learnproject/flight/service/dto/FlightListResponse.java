package com.pada.learnproject.flight.service.dto;

import com.pada.learnproject.flight.domain.FlightStatus;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightListResponse {

    private LocalDateTime flightStart;

    private LocalDateTime flightEnd;

    private FlightStatus flightStatus;

}
