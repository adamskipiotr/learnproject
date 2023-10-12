package com.pada.learnproject.example.constant;

import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.service.dto.request.ManyToOneRequest;

public interface ManyToOneEntityMother {

    String DEFAULT_MANY_TO_ONE_NAME = "DEFAULT MANY TO ONE NAME";
    String UPDATE_MANY_TO_ONE_NAME = "UPDATE MANY TO ONE NAME";

    static ManyToOneEntity createDefaultTestManyToOneEntity() {
        return ManyToOneEntity.builder()
            .manyToOneName(DEFAULT_MANY_TO_ONE_NAME)
            .build();
    }

    static ManyToOneRequest createManyToOneRequest() {
        return new ManyToOneRequest(DEFAULT_MANY_TO_ONE_NAME);
    }

    static ManyToOneRequest createUpdateManyToOneRequest() {
        return new ManyToOneRequest(UPDATE_MANY_TO_ONE_NAME);
    }
}
