package com.pada.learnproject.example.validator;

import static com.pada.learnproject.example.constant.OneToOneEntityMother.DEFAULT_ONE_COLUMN;
import static com.pada.learnproject.example.constant.OneToOneEntityMother.UPDATE_ONE_COLUMN;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pada.learnproject.example.service.dto.response.OneToOneResponse;
import org.springframework.stereotype.Component;

@Component
public class OneToOneValidator {

    public static void validateOneToOneResponse(OneToOneResponse oneToOneResponse) {
        assertEquals(DEFAULT_ONE_COLUMN, oneToOneResponse.oneColumn());
    }

    public static void validateUpdateOneToOneResponse(OneToOneResponse oneToOneResponse) {
        assertEquals(UPDATE_ONE_COLUMN, oneToOneResponse.oneColumn());
    }
}
