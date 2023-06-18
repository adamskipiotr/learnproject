package com.pada.learnproject.example.service;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.repository.ExampleEntityRepository;
import com.pada.learnproject.example.repository.OneToOneRepository;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import com.pada.learnproject.example.service.dto.ExampleResponse;
import com.pada.learnproject.example.service.mapper.ExampleEntityMapper;
import com.pada.learnproject.example.service.mapper.OneToOneMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleEntityRepository exampleEntityRepository;
    private final OneToOneRepository oneToOneRepository;
    private final ExampleEntityMapper exampleEntityMapper;
    private final OneToOneMapper oneToOneMapper;


    @Transactional
    public Page<ExampleListResponse> getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        Specification<ExampleEntity> exampleEntitySpecification = null;
        Page<ExampleEntity> exampleEntityPage = exampleEntityRepository.findAll(exampleEntitySpecification, pageable);
        return exampleEntityPage.map(exampleEntityMapper::toListResponse);
    }

    @Transactional
    public void addExampleEntity(ExampleRequest exampleRequest) {
        ExampleEntity entity = exampleEntityMapper.toEntity(exampleRequest);
        exampleEntityRepository.save(entity);
    }

    @Transactional
    public ExampleResponse getExample(Long id) {
        ExampleEntity exampleEntity = exampleEntityRepository.findById(id).orElseThrow(RuntimeException::new);
        return exampleEntityMapper.toResponse(exampleEntity);

    }
}
