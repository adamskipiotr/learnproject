package com.pada.learnproject.example.service.mapper;

import com.pada.learnproject.example.domain.ManyToManyEntity;
import com.pada.learnproject.example.service.dto.ManyToManyRequest;
import com.pada.learnproject.example.service.dto.ManyToManyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManyToManyMapper {

    ManyToManyEntity toEntity(ManyToManyRequest request);

    ManyToManyResponse toResponse(ManyToManyEntity entity);

    ManyToManyEntity updateEntity(@MappingTarget ManyToManyEntity entity, ManyToManyRequest request);
}
