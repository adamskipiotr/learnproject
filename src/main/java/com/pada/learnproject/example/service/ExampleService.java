package com.pada.learnproject.example.service;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.domain.ExampleEnum;
import com.pada.learnproject.example.repository.ExampleEntityRepository;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService {

    @Autowired
    private ExampleEntityRepository exampleEntityRepository;

    @Autowired
    private ExampleEntityMapper exampleEntityMapper;


    @Transactional
    public Page<ExampleListResponse> getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        Specification<ExampleEntity> exampleEntitySpecification = null;
        Page<ExampleEntity> exampleEntityPage = exampleEntityRepository.findAll(exampleEntitySpecification, pageable);
        return exampleEntityPage.map(entity -> exampleEntityMapper.toListResponse(entity));
    }

    @Transactional
    public void addExampleEntity(ExampleRequest exampleRequest) {
        ExampleEntity entity = exampleEntityMapper.toEntity(exampleRequest);
        exampleEntityRepository.save(entity);
    }
}
