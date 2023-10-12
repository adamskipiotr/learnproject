package com.pada.learnproject.example.repository;

import com.pada.learnproject.example.domain.ManyToManyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyRepository extends JpaRepository<ManyToManyEntity, Long>,
    JpaSpecificationExecutor<ManyToManyEntity> {
}
