package com.pada.learnproject.example.domain;


import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SortNatural;



@Entity
@Getter
@Setter
@EqualsAndHashCode
@Builder
//All args constructor and no args constructor needed -
// @Builder prevents from compiling otherwise
//  NoArgsConstructor must be before
// AllArgsConstructor in order to be used
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "example_table")
public class ExampleEntity {

    @Id
    @SequenceGenerator(name = "config_id_sequence", sequenceName = "config_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "config_id_sequence")
    private Long id;

    private String name;

    private Long value;

    @Enumerated(STRING)
    private ExampleEnum exampleEnum;

    @OneToOne(mappedBy = OneToOneEntity_.EXAMPLE_ENTITY, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OneToOneEntity oneToOneEntity;

    @OneToMany(mappedBy = ManyToOneEntity_.EXAMPLE_ENTITY, cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<ManyToOneEntity> manyToOneEntityList = new ArrayList<>();


    @SortNatural
    @Builder.Default
    //Preventing loop in hashCode
    //see more: https://stackoverflow.com/a/68605588
    @EqualsAndHashCode.Exclude
    // Good practice - use Set in ManyToMany
    // Good practice - Cascade.ALL makes no sense in ManyToMany, may be even harmful
    // https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "example_entity__many_to_many_entity",
        joinColumns = @JoinColumn(name = "example_entity_id"),
        inverseJoinColumns = @JoinColumn(name = "many_to_many_entity_id"))
    private SortedSet<ManyToManyEntity> manyToManyEntitySet = new TreeSet<>();


    // Good practice - use adder
    // https://medium.com/@rajibrath20/the-best-way-to-map-a-onetomany-relationship-with-jpa-and-hibernate-dbbf6dba00d3
    public void addManyToOneEntity(ManyToOneEntity manyToOneEntity) {
        manyToOneEntityList.add(manyToOneEntity);
        manyToOneEntity.setExampleEntity(this);
    }


    public void removeManyToOneEntity(ManyToOneEntity branch) {
        manyToOneEntityList.remove(branch);
        branch.setExampleEntity(null);
    }

    // Good practice - use adder
    // https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/
    public void addManyToManyEntity(ManyToManyEntity manyToManyEntity) {
        manyToManyEntitySet.add(manyToManyEntity);
        manyToManyEntity.getExampleEntitySet().add(this);
    }
}
