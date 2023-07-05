package com.pada.learnproject.example.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "one_to_one")
public class OneToOneEntity {

    @Id
    private Long id;

    //Good practice - mapping ID with parent
    //see:
    @MapsId
    @JoinColumn(name = "id") // owning side
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExampleEntity exampleEntity;

    private String oneColumn;

    public void setExampleEntity(ExampleEntity exampleEntity) {
        this.exampleEntity = exampleEntity;
        exampleEntity.setOneToOneEntity(this);
    }
}
