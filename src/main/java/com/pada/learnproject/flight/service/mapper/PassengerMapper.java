package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.service.dto.request.PassengerRequest;
import com.pada.learnproject.flight.service.dto.response.PassengerListResponse;
import com.pada.learnproject.flight.service.dto.response.PassengerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassengerMapper {

    Passenger toEntity(PassengerRequest request);

    PassengerResponse toResponse(Passenger entity);

    PassengerListResponse toListResponse(Passenger entity);

    Passenger updateEntity(@MappingTarget Passenger entity, PassengerRequest request);
}
