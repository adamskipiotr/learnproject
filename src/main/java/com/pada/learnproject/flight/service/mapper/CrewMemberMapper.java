package com.pada.learnproject.flight.service.mapper;

import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.service.dto.request.CrewMemberRequest;
import com.pada.learnproject.flight.service.dto.response.CrewMemberListResponse;
import com.pada.learnproject.flight.service.dto.response.CrewMemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CrewMemberMapper {

    CrewMember toEntity(CrewMemberRequest request);

    CrewMemberResponse toResponse(CrewMember entity);

    CrewMemberListResponse toListResponse(CrewMember entity);

    CrewMember updateEntity(@MappingTarget CrewMember entity, CrewMemberRequest request);
}
