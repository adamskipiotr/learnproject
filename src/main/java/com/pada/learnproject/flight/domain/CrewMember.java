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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
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

    public Flight getLastFlightEnd() {
        return flights.stream()
            .max(Comparator.comparing(Flight::getFlightEnd))
            .get();
    }

    public void isAvailableToFly(LocalDateTime flightStart, Airport startAirport) {
        Optional<Flight> optionalFlight = flights.stream()
            .filter(flight -> flight.getFlightEnd().toLocalDate().equals(flightStart.toLocalDate()))
            .max(Comparator.comparing(Flight::getFlightEnd));

        Flight f;
        if (optionalFlight.isPresent()) {
            f = optionalFlight.get();
        } else {
            return;
        }

        if (f.getEndAirport().equals(startAirport)) {
            validate1HourDelayFromTheSameAirport(f, flightStart);
        } else {
            validate12HoursDelayFromOtherAirports(f, flightStart);
        }

    }

    private void validate1HourDelayFromTheSameAirport(Flight f, LocalDateTime flightStart) {
        Duration duration = Duration.between(flightStart, f.getFlightEnd());
        if (duration.toHours() < 1) {
            throw new RuntimeException(
                "Crew member cannot take part in flight from the same airport if gap between latest landing and "
                    + "departure is less than 1 hour");
        }

    }

    private void validate12HoursDelayFromOtherAirports(Flight f, LocalDateTime flightStart) {
        Duration duration = Duration.between(flightStart, f.getFlightEnd());
        if (duration.toHours() < 12) {
            throw new RuntimeException(
                "Crew member cannot take part in flight from different airports if gap between latest landing and "
                    + "departure is less than 12 hour");
        }
    }


}
