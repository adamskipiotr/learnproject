package com.pada.learnproject.example.validator;

import static com.pada.learnproject.example.constant.ManyToManyEntityMother.DEFAULT_MANY_TO_MANY_NAME;
import static com.pada.learnproject.example.constant.ManyToManyEntityMother.UPDATE_MANY_TO_MANY_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.example.service.dto.response.ManyToManyResponse;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class ManyToManyValidator {

    public static void validateManyToManyResponseSet(Set<ManyToManyResponse> manyToManyResponseList) {
        assertEquals(1, manyToManyResponseList.size());

        var exampleListResponse = manyToManyResponseList.stream().findFirst().get();
        assertEquals(DEFAULT_MANY_TO_MANY_NAME, exampleListResponse.manyToManyName());
    }

    public static void validateUpdateManyToManyResponseSet(Set<ManyToManyResponse> manyToManyResponseList) {
        assertEquals(2, manyToManyResponseList.size());

        var exampleListResponse = manyToManyResponseList.stream().findFirst().get();
        assertEquals(UPDATE_MANY_TO_MANY_NAME, exampleListResponse.manyToManyName());
    }
}
