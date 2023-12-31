package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.service.dto.request.FlightRequest;
import com.pada.learnproject.flight.service.dto.response.FlightListResponse;
import com.pada.learnproject.flight.service.dto.response.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {CrewMemberMapper.class,
    AirportMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper {

    @Mapping(target = "flightStatus", constant = "SCHEDULED")
    Flight toEntity(FlightRequest request);

    FlightResponse toResponse(Flight flight);

    FlightListResponse toListResponse(Flight flight);

    Flight updateEntity(@MappingTarget Flight flight, FlightRequest flightRequest);
}
