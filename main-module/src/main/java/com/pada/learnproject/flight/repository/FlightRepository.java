package com.pada.learnproject.flight.repository;

import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.Flight_;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {



    interface Specs {

        static Specification<Flight> flightStartBetween(Specification<Flight> specification,
            LocalDateTime lowerBoundary,
            LocalDateTime upperBoundary) {
            if (lowerBoundary != null && upperBoundary != null) {
                specification = specification.and((root, query, builder) ->
                    builder.between(root.get(Flight_.flightStart), lowerBoundary, upperBoundary));
            }
            return specification;
        }

    }
}
