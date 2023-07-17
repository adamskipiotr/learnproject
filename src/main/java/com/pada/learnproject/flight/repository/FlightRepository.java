package com.pada.learnproject.flight.repository;

import com.pada.learnproject.example.domain.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<ExampleEntity, Long>{
}
