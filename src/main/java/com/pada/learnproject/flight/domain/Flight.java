package com.pada.learnproject.flight.domain;

import static jakarta.persistence.EnumType.STRING;

import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.domain.ManyToOneEntity_;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "flight")
public class Flight {

    @Id
    @SequenceGenerator(name = "flight_id_sequence", sequenceName = "flight_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_id_sequence")
    private Long id;

    private LocalDateTime flightStart;

    private LocalDateTime flightEnd;

    @Enumerated(STRING)
    private FlightStatus flightStatus;

    private Integer maxPassengerCount;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "flights__crew_members",
        joinColumns = @JoinColumn(name = "flight_id"),
        inverseJoinColumns = @JoinColumn(name = "crew_member_id"))
    private Set<CrewMember> crewMembers = new HashSet<>();

    @OneToMany(mappedBy = Ticket_.FLIGHT, cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport startAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport endAirport;

}
