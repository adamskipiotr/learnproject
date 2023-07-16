package com.pada.learnproject.example.constant;

import static com.pada.learnproject.example.constant.ManyToManyEntityMother.createManyToManyRequest;
import static com.pada.learnproject.example.constant.ManyToManyEntityMother.createUpdateManyToManyRequest;
import static com.pada.learnproject.example.constant.ManyToOneEntityMother.createManyToOneRequest;
import static com.pada.learnproject.example.constant.ManyToOneEntityMother.createUpdateManyToOneRequest;
import static com.pada.learnproject.example.constant.OneToOneEntityMother.createOneToOneRequest;
import static com.pada.learnproject.example.constant.OneToOneEntityMother.createUpdateOneToOneRequest;

import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.domain.ExampleEnum;
import com.pada.learnproject.example.service.dto.request.ExampleRequest;
import java.util.List;
import java.util.Set;

public interface ExampleEntityMother {

    String DEFAULT_EXAMPLE_ENTITY_NAME = "DEFAULT EXAMPLE ENTITY NAME";
    String INVALID_DEFAULT_EXAMPLE_ENTITY_NAME = "INVALID EXAMPLE ENTITY NAME";
    Long DEFAULT_EXAMPLE_ENTITY_VALUE = 1000L;
    ExampleEnum DEFAULT_EXAMPLE_ENUM = ExampleEnum.POSITION_1;
    String SECOND_EXAMPLE_ENTITY_NAME = "SECOND EXAMPLE ENTITY NAME";
    Long SECOND_EXAMPLE_ENTITY_VALUE = 2000L;
    ExampleEnum SECOND_EXAMPLE_ENUM = ExampleEnum.POSITION_2;

    String THIRD_EXAMPLE_ENTITY_NAME = "THIRD EXAMPLE ENTITY NAME";
    Long THIRD_EXAMPLE_ENTITY_VALUE = 3000L;
    ExampleEnum THIRD_EXAMPLE_ENUM = ExampleEnum.POSITION_3;

    String UPDATE_EXAMPLE_ENTITY_NAME = "UPDATE EXAMPLE ENTITY NAME";
    Long UPDATE_EXAMPLE_ENTITY_VALUE = 1111L;
    ExampleEnum UPDATE_EXAMPLE_ENUM = ExampleEnum.POSITION_2;
    Long NON_EXISTING_ID = -1L;

    static ExampleEntity createDefaultTestExampleEntity() {
        return ExampleEntity.builder()
            .name(DEFAULT_EXAMPLE_ENTITY_NAME)
            .value(DEFAULT_EXAMPLE_ENTITY_VALUE)
            .exampleEnum(DEFAULT_EXAMPLE_ENUM)
            .build();
    }

    static ExampleEntity createSecondTestExampleEntity() {
        return ExampleEntity.builder()
            .name(SECOND_EXAMPLE_ENTITY_NAME)
            .value(SECOND_EXAMPLE_ENTITY_VALUE)
            .exampleEnum(SECOND_EXAMPLE_ENUM)
            .build();
    }

    static ExampleEntity createThirdTestExampleEntity() {
        return ExampleEntity.builder()
            .name(THIRD_EXAMPLE_ENTITY_NAME)
            .value(THIRD_EXAMPLE_ENTITY_VALUE)
            .exampleEnum(THIRD_EXAMPLE_ENUM)
            .build();
    }

    static ExampleRequest createExampleRequest() {
        return new ExampleRequest(DEFAULT_EXAMPLE_ENTITY_NAME, DEFAULT_EXAMPLE_ENTITY_VALUE,
            createOneToOneRequest(), List.of(createManyToOneRequest()), Set.of(createManyToManyRequest()));
    }

    static ExampleRequest createUpdateExampleRequest() {
        return new ExampleRequest(UPDATE_EXAMPLE_ENTITY_NAME, UPDATE_EXAMPLE_ENTITY_VALUE,
            createUpdateOneToOneRequest(), List.of(createUpdateManyToOneRequest()),
            Set.of(createUpdateManyToManyRequest()));
    }
}
