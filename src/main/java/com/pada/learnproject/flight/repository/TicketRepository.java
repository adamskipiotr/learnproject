package com.pada.learnproject.flight.repository;

import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.domain.TicketClass;
import com.pada.learnproject.flight.domain.Ticket_;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {

    interface Specs {
        static Specification<Ticket> byPriceTo(Specification<Ticket> specification, Integer value,
            SingularAttribute<Ticket, Integer> field) {
            if (value != null) {
                specification = specification.and((root, query, builder) ->
                    builder.lessThanOrEqualTo(root.get(field), value));
            }
            return specification;
        }

        static Specification<Ticket> byTicketClass(Specification<Ticket> specification, TicketClass value ) {
            if (value != null) {
                specification = specification.and((root, query, builder) ->
                    builder.equal(root.get(Ticket_.ticketClass), value));
            }
            return specification;
        }

    }
}
