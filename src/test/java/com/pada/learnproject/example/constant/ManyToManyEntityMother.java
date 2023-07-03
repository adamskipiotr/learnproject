package com.pada.learnproject.example.constant;

import com.pada.learnproject.example.domain.ManyToManyEntity;
import com.pada.learnproject.example.service.dto.request.ManyToManyRequest;

public interface ManyToManyEntityMother {

    String DEFAULT_MANY_TO_MANY_NAME = "DEFAULT MANY TO MANY NAME";
    String UPDATE_MANY_TO_MANY_NAME = "UPDATE MANY TO MANY NAME";

    static ManyToManyEntity createDefaultTestManyToManyEntity() {
        return ManyToManyEntity.builder()
            .manyToManyName(DEFAULT_MANY_TO_MANY_NAME)
            .build();
    }

    static ManyToManyRequest createManyToManyRequest() {
        return new ManyToManyRequest(DEFAULT_MANY_TO_MANY_NAME);
    }

    static ManyToManyRequest createUpdateManyToManyRequest() {
        return new ManyToManyRequest(UPDATE_MANY_TO_MANY_NAME);
    }
}
