package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.service.dto.TicketListResponse;
import com.pada.learnproject.flight.service.dto.TicketRequest;
import com.pada.learnproject.flight.service.dto.TicketResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    Ticket toEntity(TicketRequest request);

    TicketResponse toResponse(Ticket entity);

    TicketListResponse toListResponse(Ticket entity);

    Ticket updateEntity(@MappingTarget Ticket entity, TicketRequest request);
}
