package com.pada.learnproject.flight.domain.criteria;

import com.pada.learnproject.flight.domain.TicketClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketCriteria {

    private TicketClass ticketClass;

    private Integer basePrice;

    private Integer luggageFee;

}
