package com.pada.learnproject.example.service.dto;

import static jakarta.persistence.EnumType.STRING;

import com.pada.learnproject.example.domain.ExampleEnum;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExampleRequest {

    public String name;

    private Long value;

    @Enumerated(STRING)
    private ExampleEnum exampleEnum;
}
