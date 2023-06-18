package com.pada.learnproject.example.service;

import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExampleEntityMapper {

    ExampleListResponse toListResponse(ExampleEntity entity);

    ExampleEntity toEntity(ExampleRequest request);
}
