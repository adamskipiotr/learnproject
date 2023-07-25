package com.pada.learnproject.flight.service;

import com.pada.learnproject.flight.domain.WeatherCondition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AirportCriteria {

    private String name;

    private WeatherCondition weatherCondition;
}
