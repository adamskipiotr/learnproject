package com.pada.learnproject.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "many_to_many")
@Table(name = "many_to_many")
public class ManyToManyEntity implements Comparable<ManyToManyEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String manyToManyName;


    @ManyToMany(mappedBy = ExampleEntity_.MANY_TO_MANY_ENTITY_SET)
    private Set<ExampleEntity> exampleEntitySet = new HashSet<>();


    public int compareTo(ManyToManyEntity o) {
        return manyToManyName.compareTo(o.getManyToManyName());
    }
}
