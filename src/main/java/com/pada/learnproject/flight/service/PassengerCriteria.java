package com.pada.learnproject.flight.service;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PassengerCriteria {

    private String firstName;

    private String lastName;

    private Integer age;

    private Boolean isPremium;
}
