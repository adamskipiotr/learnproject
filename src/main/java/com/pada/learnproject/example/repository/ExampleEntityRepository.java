package com.pada.learnproject.example.repository;

import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.domain.ExampleEntity_;
import com.pada.learnproject.example.service.dto.response.ExampleProjection;
import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long>,
    JpaSpecificationExecutor<ExampleEntity> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<ExampleEntity> findWithLockingById(Long id);

    <T> T findByName(String name, Class<T> type);

    interface Specs {

        static Specification<ExampleEntity> byValue(Specification<ExampleEntity> specification, Long value) {
            if (value != null) {
                specification = specification.and((root, query, builder) ->
                    builder.equal(root.get(ExampleEntity_.value), value));
            }
            return specification;
        }

        static Specification<ExampleEntity> byNameLike(Specification<ExampleEntity> specification,
            String name) {
            if (name != null) {
                specification = specification.and((root, query, builder) ->
                    builder.like(root.get(ExampleEntity_.name),"%" + name + "%"));
            }
            return specification;
        }
    }
}
