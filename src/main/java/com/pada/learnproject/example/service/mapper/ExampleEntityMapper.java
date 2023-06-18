package com.pada.learnproject.example.service.mapper;

import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import com.pada.learnproject.example.service.dto.ExampleResponse;
import java.util.Optional;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = OneToOneMapper.class)
public interface ExampleEntityMapper {

    ExampleListResponse toListResponse(ExampleEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "oneToOneEntity", source = "oneToOneRequest")
    ExampleEntity toEntity(ExampleRequest request);

    @AfterMapping
    default void setExampleEntity(@MappingTarget ExampleEntity exampleEntity) {
        Optional.ofNullable(exampleEntity.getOneToOneEntity())
            .ifPresent(it -> it.setExampleEntity(exampleEntity));
    }

    @Mapping(target = "oneToOneResponse", source = "oneToOneEntity")
    ExampleResponse toResponse(ExampleEntity exampleEntity);
}
