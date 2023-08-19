package com.pada.learnproject.flight.domain;

import static com.pada.learnproject.flight.service.FlightType.ARRIVAL;
import static com.pada.learnproject.flight.service.FlightType.DEPARTURE;
import static jakarta.persistence.EnumType.STRING;

import com.pada.learnproject.flight.service.FlightType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
@Table(name = "airport")
public class Airport {

    @Id
    @SequenceGenerator(name = "airport_id_sequence", sequenceName = "airport_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_id_sequence")
    private Long id;

    private String name;

    @Enumerated(STRING)
    private WeatherCondition weatherCondition;

    @OneToMany(mappedBy = Flight_.START_AIRPORT, cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<Flight> departures = new ArrayList<>();

    @OneToMany(mappedBy = Flight_.END_AIRPORT, cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<Flight> arrivals = new ArrayList<>();

    public Flight getLastArrival() {
        return arrivals
            .stream()
            .max(Comparator.comparing(Flight::getFlightEnd))
            .get();
    }

    public Flight getLastDeparture() {
        return arrivals
            .stream()
            .max(Comparator.comparing(Flight::getFlightStart))
            .get();
    }

    public boolean isPreviousDepartureBeforeNew(Flight flight) {
        return getLastDeparture().getFlightStart().plus(5, ChronoUnit.MINUTES)
            .isBefore(flight.getFlightStart());
    }

    public boolean isPreviousArrivalBeforeNew(Flight flight) {
        return getLastArrival().getFlightEnd().plus(5, ChronoUnit.MINUTES)
            .isBefore(flight.getFlightStart());
    }

    public void addDepartureFlight(Flight flight) {
        if (!isPreviousDepartureBeforeNew(flight)) {
            throw new RuntimeException("Previous departure is too close");
        }
        flight.setStartAirport(this);
    }

    public void addArrivalFlight(Flight flight) {
        if (!isPreviousArrivalBeforeNew(flight)) {
            throw new RuntimeException("Previous arrival is too close");
        }
        flight.setEndAirport(this);
    }
}
