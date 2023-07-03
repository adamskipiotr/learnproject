package com.pada.learnproject.example.service.mapper;

import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.service.dto.request.ManyToOneRequest;
import com.pada.learnproject.example.service.dto.response.ManyToOneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManyToOneMapper {

    ManyToOneEntity toEntity(ManyToOneRequest request);

    ManyToOneResponse toResponse(ManyToOneEntity entity);

    ManyToOneEntity updateEntity(@MappingTarget ManyToOneEntity entity, ManyToOneRequest request);
}
