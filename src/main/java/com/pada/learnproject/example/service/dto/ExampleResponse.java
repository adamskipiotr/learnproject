package com.pada.learnproject.example.service.dto;

import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExampleResponse {

    private Long id;

    private String name;

    private Long value;

    private OneToOneResponse oneToOneResponse;

    private List<ManyToOneResponse> manyToOneResponseList;

    private Set<ManyToManyResponse> manyToManyResponseSet;

}
