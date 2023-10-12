package com.pada.learnproject.flight.repository;

import com.pada.learnproject.flight.domain.Airport;
import com.pada.learnproject.flight.domain.Airport_;
import com.pada.learnproject.flight.domain.WeatherCondition;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>, JpaSpecificationExecutor<Airport> {

    interface Specs {

            static Specification<Airport> byWeatherCondition(Specification<Airport> specification, WeatherCondition value) {
                if (value != null) {
                    specification = specification.and((root, query, builder) ->
                        builder.equal(root.get(Airport_.weatherCondition), value));
                }
                return specification;
            }

        static Specification<Airport> airportByNameLike(Specification<Airport> specification,
            String name, SingularAttribute<Airport, String> attribute) {
            if (name != null) {
                specification = specification.and((root, query, builder) ->
                    builder.like(root.get(attribute), "%" + name + "%"));
            }
            return specification;
        }
    }
}
