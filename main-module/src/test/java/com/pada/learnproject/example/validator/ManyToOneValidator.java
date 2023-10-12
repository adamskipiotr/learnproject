package com.pada.learnproject.example.validator;

import static com.pada.learnproject.example.constant.ManyToOneEntityMother.DEFAULT_MANY_TO_ONE_NAME;
import static com.pada.learnproject.example.constant.ManyToOneEntityMother.UPDATE_MANY_TO_ONE_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pada.learnproject.example.service.dto.response.ManyToOneResponse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ManyToOneValidator {

    public static void validateManyToOneResponseList(List<ManyToOneResponse> manyToOneResponseList) {
        assertEquals(1, manyToOneResponseList.size());

        var manyToOneResponse = manyToOneResponseList.get(0);
        assertEquals(DEFAULT_MANY_TO_ONE_NAME, manyToOneResponse.manyToOneName());
    }

    public static void validateUpdateManyToOneResponseList(List<ManyToOneResponse> manyToOneResponseList) {
        assertEquals(2, manyToOneResponseList.size());

        assertTrue(manyToOneResponseList.stream().anyMatch(entity -> UPDATE_MANY_TO_ONE_NAME.equals(entity.manyToOneName())));
        assertTrue(manyToOneResponseList.stream().anyMatch(entity -> DEFAULT_MANY_TO_ONE_NAME.equals(entity.manyToOneName())));
    }
}
