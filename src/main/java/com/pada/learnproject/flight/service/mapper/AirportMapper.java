package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.service.dto.request.AirportRequest;
import com.pada.learnproject.flight.service.dto.response.AirportListResponse;
import com.pada.learnproject.flight.service.dto.response.AirportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper {

    Airport toEntity(AirportRequest request);

    AirportResponse toResponse(Airport entity);

    AirportListResponse toListResponse(Airport entity);

    Airport updateEntity(@MappingTarget Airport entity, AirportRequest request);
}
