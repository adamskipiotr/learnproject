package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.WeatherCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportResponse {
    String name;
    WeatherCondition weatherCondition;
}
