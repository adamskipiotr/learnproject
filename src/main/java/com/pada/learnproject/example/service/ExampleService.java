package com.pada.learnproject.example.service;

import static com.pada.learnproject.example.repository.ExampleEntityRepository.Specs.byNameLike;
import static com.pada.learnproject.example.repository.ExampleEntityRepository.Specs.byValue;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.repository.ExampleEntityRepository;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import com.pada.learnproject.example.service.dto.ExampleResponse;
import com.pada.learnproject.example.service.mapper.ExampleEntityMapper;
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
    private final ExampleEntityMapper exampleEntityMapper;


    @Transactional
    public Page<ExampleListResponse> getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        Specification<ExampleEntity> exampleEntitySpecification = createSpecification(exampleCriteria);
        Page<ExampleEntity> exampleEntityPage = exampleEntityRepository.findAll(exampleEntitySpecification, pageable);
        return exampleEntityPage.map(exampleEntityMapper::toListResponse);
    }


    private Specification<ExampleEntity> createSpecification(ExampleCriteria filter) {
        Specification<ExampleEntity> specification = Specification.where(null);
        specification = byValue(specification, filter.getValue());
        specification = byNameLike(specification, filter.getName());
        return specification;

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

    @Transactional
    public ExampleResponse updateExampleEntity(ExampleRequest exampleRequest, Long id) {
        ExampleEntity entity = exampleEntityRepository.findById(id).orElseThrow(RuntimeException::new);
        entity = exampleEntityMapper.updateEntity(entity, exampleRequest);
        exampleEntityRepository.save(entity);
        return exampleEntityMapper.toResponse(entity);
    }

    @Transactional
    public void deleteExample(Long id) {
        exampleEntityRepository.deleteById(id);
    }
}
