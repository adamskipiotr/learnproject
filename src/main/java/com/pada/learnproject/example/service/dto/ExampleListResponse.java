package com.pada.learnproject.example.service.dto;

import com.pada.learnproject.example.domain.ExampleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExampleListResponse {

    private Long id;

    private String name;

    private Long value;

 //   private ExampleEnum exampleEnum;
}
