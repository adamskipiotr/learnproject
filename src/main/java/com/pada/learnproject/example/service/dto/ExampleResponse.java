package com.pada.learnproject.example.service.dto;

import java.util.List;
import java.util.Set;

public record ExampleResponse(
    Long id,
    String name,
    Long value,
    OneToOneResponse oneToOneResponse,
    List<ManyToOneResponse> manyToOneResponseList,
    Set<ManyToManyResponse> manyToManyResponseSet
) {
}