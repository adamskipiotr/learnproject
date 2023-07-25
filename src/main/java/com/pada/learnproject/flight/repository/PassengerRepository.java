package com.pada.learnproject.flight.repository;

import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.domain.Passenger_;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>, JpaSpecificationExecutor<Passenger> {

    interface Specs {

        static Specification<Passenger> byAgeFrom(Specification<Passenger> specification, Integer value) {
            if (value != null) {
                specification = specification.and((root, query, builder) ->
                    builder.lessThanOrEqualTo(root.get(Passenger_.age), value));
            }
            return specification;
        }

        static Specification<Passenger> byIsPremium(Specification<Passenger> specification, Boolean value) {
            if (value != null) {
                specification = specification.and((root, query, builder) ->
                    builder.lessThanOrEqualTo(root.get(Passenger_.isPremium), value));
            }
            return specification;
        }

        static Specification<Passenger> byNameLike(Specification<Passenger> specification,
            String name, SingularAttribute<Passenger, String> attribute) {
            if (name != null) {
                specification = specification.and((root, query, builder) ->
                    builder.like(root.get(attribute), "%" + name + "%"));
            }
            return specification;
        }
    }
}
