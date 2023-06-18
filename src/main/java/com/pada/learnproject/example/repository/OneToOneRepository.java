package com.pada.learnproject.example.repository;

import com.pada.learnproject.example.domain.OneToOneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToOneRepository extends JpaRepository<OneToOneEntity, Long>,
    JpaSpecificationExecutor<OneToOneEntity> {
}
