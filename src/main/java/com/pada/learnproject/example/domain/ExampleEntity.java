package com.pada.learnproject.example.domain;


import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "example_table")
public class ExampleEntity {

    @Id
    @SequenceGenerator(name = "config_id_sequence", sequenceName = "config_id_seq", allocationSize = 22)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "config_id_sequence")
    private Long id;

    private String name;

    private Long value;

    @Enumerated(STRING)
    private ExampleEnum exampleEnum;

    @OneToOne(mappedBy = "exampleEntity", cascade = CascadeType.ALL)
    private OneToOneEntity oneToOneEntity;

}
