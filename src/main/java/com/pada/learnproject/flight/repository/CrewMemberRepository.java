package com.pada.learnproject.flight.repository;

import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.Flight;
import com.pada.learnproject.flight.domain.Flight_;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long>, JpaSpecificationExecutor<CrewMember> {

}
