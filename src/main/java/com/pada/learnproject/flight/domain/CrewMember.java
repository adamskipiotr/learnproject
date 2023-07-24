package com.pada.learnproject.flight.domain;

import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crew_member")
public class CrewMember {

    @Id
    @SequenceGenerator(name = "crew_member_id_sequence", sequenceName = "crew_member_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crew_member_id_sequence")
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(STRING)
    private CrewMemberRank crewMemberRank;

    private Integer age;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = Flight_.CREW_MEMBERS, fetch = FetchType.LAZY)
    private Set<Flight> flights = new HashSet<>();

}
