package com.pada.learnproject.example.service.mapper;

import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import com.pada.learnproject.example.service.dto.ExampleResponse;
import java.util.Optional;
import org.mapstruct.AfterMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {OneToOneMapper.class, ManyToOneMapper.class, ManyToManyMapper.class},
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExampleEntityMapper {

    ExampleListResponse toListResponse(ExampleEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "oneToOneEntity", source = "oneToOneRequest")
    @Mapping(target = "manyToOneEntityList", source = "manyToOneRequestList")
    @Mapping(target = "manyToManyEntitySet", source = "manyToManyRequestSet")
    ExampleEntity toEntity(ExampleRequest request);

    @AfterMapping
    default void setExampleEntity(@MappingTarget ExampleEntity exampleEntity) {
        Optional.ofNullable(exampleEntity.getOneToOneEntity())
            .ifPresent(oneToOneEntity -> oneToOneEntity.setExampleEntity(exampleEntity));
    }

    @Mapping(target = "oneToOneResponse", source = "oneToOneEntity")
    @Mapping(target = "manyToOneResponseList", source = "manyToOneEntityList")
    @Mapping(target = "manyToManyResponseSet", source = "manyToManyEntitySet")
    ExampleResponse toResponse(ExampleEntity exampleEntity);

    ExampleEntity updateEntity(@MappingTarget ExampleEntity entity, ExampleRequest request);
}
