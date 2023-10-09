package com.pada.learnproject.flight.repository;

import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.CrewMember_;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long>, JpaSpecificationExecutor<CrewMember> {

    interface Specs {

        static Specification<CrewMember> byAgeFrom(Specification<CrewMember> specification, Integer value) {
            if (value != null) {
                specification = specification.and((root, query, builder) ->
                    builder.lessThanOrEqualTo(root.get(CrewMember_.age), value));
            }
            return specification;
        }

        static Specification<CrewMember> byNameLike(Specification<CrewMember> specification,
            String name, SingularAttribute<CrewMember, String> attribute) {
            if (name != null) {
                specification = specification.and((root, query, builder) ->
                    builder.like(root.get(attribute), "%" + name + "%"));
            }
            return specification;
        }
    }

}
