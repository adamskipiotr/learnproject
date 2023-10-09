package com.pada.learnproject.flight.service.dto.response;

import com.pada.learnproject.flight.domain.TicketClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketListResponse {
    private String flightName;
    private TicketClass ticketClass;
    private Integer basePrice;
    private Integer luggageFee;
    private String passengerData;
}