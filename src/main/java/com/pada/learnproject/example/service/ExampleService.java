package com.pada.learnproject.example.service;

import static com.pada.learnproject.example.repository.ExampleEntityRepository.Specs.byNameLike;
import static com.pada.learnproject.example.repository.ExampleEntityRepository.Specs.byValue;
import static java.util.stream.Collectors.toList;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.repository.ExampleEntityRepository;
import com.pada.learnproject.example.service.dto.response.ExampleListResponse;
import com.pada.learnproject.example.service.dto.request.ExampleRequest;
import com.pada.learnproject.example.service.dto.response.ExampleListWrapperResponse;
import com.pada.learnproject.example.service.dto.response.ExampleProjection;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import com.pada.learnproject.example.service.mapper.ExampleEntityMapper;
import java.util.List;
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
    public ExampleListWrapperResponse getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        Specification<ExampleEntity> exampleEntitySpecification = createSpecification(exampleCriteria);
        Page<ExampleEntity> exampleEntityPage = exampleEntityRepository.findAll(exampleEntitySpecification, pageable);

        List<ExampleListResponse> data = exampleEntityPage
            .stream()
            .map(exampleEntityMapper::toListResponse)
            .collect(toList());

        return new ExampleListWrapperResponse(data);
    }


    private Specification<ExampleEntity> createSpecification(ExampleCriteria filter) {
        Specification<ExampleEntity> specification = Specification.where(null);
        specification = byValue(specification, filter.getValue());
        specification = byNameLike(specification, filter.getName());

        return specification;

    }

    @Transactional
    public ExampleResponse addExampleEntity(ExampleRequest exampleRequest) {
        ExampleEntity entity = exampleEntityMapper.toEntity(exampleRequest);
        //TODO refactor setter
        entity.getOneToOneEntity().setExampleEntity(entity);
        return exampleEntityMapper.toResponse(entity);
    }

    @Transactional
    public ExampleResponse getExample(Long id) {
        ExampleEntity exampleEntity = exampleEntityRepository.findById(id).orElseThrow(RuntimeException::new);
        return exampleEntityMapper.toResponse(exampleEntity);

    }

    @Transactional
    //TODO manyToOne updating - expected behaviour to update existing and add new
    public ExampleResponse updateExampleEntity(ExampleRequest exampleRequest, Long id) {
        ExampleEntity entity = exampleEntityRepository.findById(id).orElseThrow(RuntimeException::new);
        entity = exampleEntityMapper.updateEntity(entity, exampleRequest);
        //save not needed with JPA
        return exampleEntityMapper.toResponse(entity);
    }

    @Transactional
    public ExampleResponse deleteExample(Long id) {
        ExampleEntity entity = exampleEntityRepository.findById(id).orElseThrow(RuntimeException::new);
        exampleEntityRepository.deleteById(id);
        return exampleEntityMapper.toResponse(entity);
    }
}
