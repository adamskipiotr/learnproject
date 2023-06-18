package com.pada.learnproject.example.repository;

import com.pada.learnproject.example.domain.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long>,
    JpaSpecificationExecutor<ExampleEntity> {
}
