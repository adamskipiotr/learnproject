package com.pada.learnproject.example.service.mapper;

import com.pada.learnproject.example.domain.OneToOneEntity;
import com.pada.learnproject.example.service.dto.OneToOneRequest;
import com.pada.learnproject.example.service.dto.OneToOneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OneToOneMapper {

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "exampleEntity", source = "exampleRequest")
    OneToOneEntity toEntity(OneToOneRequest request);

    OneToOneResponse toResponse(OneToOneEntity entity);
}
