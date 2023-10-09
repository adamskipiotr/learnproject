package com.pada.learnproject.flight.service.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponse {
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean isPremium;
    private List<TicketResponse> tickets;
}