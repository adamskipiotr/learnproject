package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.TicketClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    private TicketClass ticketClass;
    private Integer basePrice;
    private Integer luggageFee;
}