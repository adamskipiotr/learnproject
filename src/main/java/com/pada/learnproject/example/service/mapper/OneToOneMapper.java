package com.pada.learnproject.example.service.mapper;

import com.pada.learnproject.example.domain.OneToOneEntity;
import com.pada.learnproject.example.service.dto.OneToOneRequest;
import com.pada.learnproject.example.service.dto.OneToOneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OneToOneMapper {

    OneToOneEntity toEntity(OneToOneRequest request);

    OneToOneResponse toResponse(OneToOneEntity entity);

    OneToOneEntity updateEntity(@MappingTarget OneToOneEntity entity, OneToOneRequest request);
}
