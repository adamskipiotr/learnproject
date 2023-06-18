package com.pada.learnproject.example.service.dto;

import static jakarta.persistence.EnumType.STRING;

import com.pada.learnproject.example.domain.ExampleEnum;
import com.pada.learnproject.example.domain.OneToOneEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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

}
