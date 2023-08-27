package com.pada.learnproject.flight.domain;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    private String flightName;

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

    public void addTicket(Ticket ticket){
        if(tickets.size() >= maxPassengerCount){
            throw new RuntimeException("Maximum airplane flight passengers count reached");
        }
        tickets.add(ticket);
        ticket.setFlight(this);
    }

    public void removeTicket(Ticket ticket){
        validateFlightStatusBeforeRemovingRelated(ticket.getClass().getName());
        tickets.remove(ticket);
        ticket.setFlight(null);
    }

    public void addCrewMember(CrewMember crewMember){
        crewMember.isAvailableToFly(flightStart, startAirport);

        crewMembers.add(crewMember);
        crewMember.getFlights().add(this);
    }

    public void removeCrewMember(CrewMember crewMember){
        validateFlightStatusBeforeRemovingRelated(crewMembers.getClass().getName());
        crewMembers.remove(crewMember);
        crewMember.getFlights().remove(this);
    }

    private void validateFlightStatusBeforeRemovingRelated(String name) {
        if(!flightStatus.isRemovable()){
            throw new RuntimeException("Cannot remove " + name + " flight status is not scheduled");
        }
    }

    public void changeFlightStatus(FlightStatus newFlightStatus) {
        validateFlightForOngoing(newFlightStatus);
        flightStatus.changeValue(newFlightStatus);
    }

    private void validateFlightForOngoing(FlightStatus newFlightStatus) {
        if (newFlightStatus == FlightStatus.ONGOING) {
            validateFlightDetails();
            validateCrewMembersForOngoing();
        }
    }

    private void validateFlightDetails() {
        Map<Object, String> fieldToName = new HashMap<>();
        fieldToName.put(flightName, "flightName");
        fieldToName.put(flightStart, "flightStart");
        fieldToName.put(flightEnd, "flightEnd");
        fieldToName.put(maxPassengerCount, "maxPassengerCount");
        fieldToName.put(startAirport, "startAirport");
        fieldToName.put(endAirport, "endAirport");

        List<String> missingFields = fieldToName.entrySet().stream()
            .filter(entry -> entry.getKey() == null)
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());

        if (!missingFields.isEmpty()) {
            String missingFieldNames = String.join(", ", missingFields);
            throw new RuntimeException("Cannot change flight status to Ongoing. Required fields are missing: " + missingFieldNames);
        }
    }

    private void validateCrewMembersForOngoing() {
        if (this.crewMembers.size() < 2) {
            throw new RuntimeException("Cannot change flight status to Ongoing. Too few crew members.");
        }
    }
}
