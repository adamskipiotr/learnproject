package com.pada.learnproject.example.service.dto;

import static jakarta.persistence.EnumType.STRING;

import com.pada.learnproject.example.domain.ExampleEnum;
import jakarta.persistence.Enumerated;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ExampleRequest (

     String name,

     Long value,


     OneToOneRequest oneToOneRequest,

     List<ManyToOneRequest> manyToOneRequestList,

     Set<ManyToManyRequest> manyToManyRequestSet
){}


//@Getter
//@Setter
//@NoArgsConstructor
//public class ExampleRequest {
//
//    public String name;
//
//    private Long value;
//
//    @Enumerated(STRING)
//    private ExampleEnum exampleEnum;
//
//    private OneToOneRequest oneToOneRequest;
//
//    private List<ManyToOneRequest> manyToOneRequestList;
//
//    private Set<ManyToManyRequest> manyToManyRequestSet;
//}
