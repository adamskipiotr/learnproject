package com.pada.learnproject.example.constant;

import com.pada.learnproject.example.domain.OneToOneEntity;
import com.pada.learnproject.example.service.dto.request.OneToOneRequest;

public interface OneToOneEntityMother {

    String DEFAULT_ONE_COLUMN = "DEFAULT ONE COLUMN";
    String UPDATE_ONE_COLUMN = "UPDATE ONE COLUMN";

    static OneToOneEntity createDefaultTestOneToOneEntity() {
        return OneToOneEntity.builder()
            .oneColumn(DEFAULT_ONE_COLUMN)
            .build();
    }

    static OneToOneRequest createOneToOneRequest() {
        return new OneToOneRequest(DEFAULT_ONE_COLUMN);
    }

    static OneToOneRequest createUpdateOneToOneRequest() {
        return new OneToOneRequest(UPDATE_ONE_COLUMN);
    }
}
