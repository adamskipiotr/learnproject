package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.service.dto.FlightListResponse;
import com.pada.learnproject.flight.service.dto.FlightRequest;
import com.pada.learnproject.flight.service.dto.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper {

    @Mapping(target = "flightStatus", constant = "SCHEDULED")
    Flight toEntity(FlightRequest request);

    FlightResponse toResponse(Flight flight);

    FlightListResponse toListResponse(Flight flight);

    Flight updateEntity(@MappingTarget Flight flight, FlightRequest flightRequest);
}
