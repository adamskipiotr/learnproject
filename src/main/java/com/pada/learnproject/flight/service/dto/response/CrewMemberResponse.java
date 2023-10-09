package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.CrewMemberRank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrewMemberResponse {
    private String firstName;
    private String lastName;
    private CrewMemberRank crewMemberRank;
    private Integer age;
}