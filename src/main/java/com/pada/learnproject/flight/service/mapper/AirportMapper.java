package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.service.dto.AirportListResponse;
import com.pada.learnproject.flight.service.dto.AirportRequest;
import com.pada.learnproject.flight.service.dto.AirportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper {

    Airport toEntity(AirportRequest request);

    AirportResponse toResponse(Airport flight);

    AirportListResponse toListResponse(Airport flight);

    Airport updateEntity(@MappingTarget Airport flight, AirportRequest flightRequest);
}
