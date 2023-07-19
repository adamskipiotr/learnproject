package com.pada.learnproject.common.infractructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private final String code;
    private final String name;
    private final String description;
}
