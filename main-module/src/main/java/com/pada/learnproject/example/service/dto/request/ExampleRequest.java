package com.pada.learnproject.example.service.dto.request;

import java.util.List;
import java.util.Set;

public record ExampleRequest(

    String name,

    Long value,

    OneToOneRequest oneToOneRequest,

    List<ManyToOneRequest> manyToOneRequestList,

    Set<ManyToManyRequest> manyToManyRequestSet
) {
}
