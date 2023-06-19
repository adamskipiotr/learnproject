package com.pada.learnproject.example.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManyToManyResponse {

    private Long id;

    private String manyToManyName;
}
