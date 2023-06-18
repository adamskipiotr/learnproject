package com.pada.learnproject.example.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "one_to_one")
public class OneToOneEntity {

    @Id
    private Long id;

    @MapsId
    @JoinColumn(name = "id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExampleEntity exampleEntity;

    private String oneColumn;
}
