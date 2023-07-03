package com.pada.learnproject.example.service;

import com.pada.learnproject.example.domain.ExampleEntity;
import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.repository.ExampleEntityRepository;
import com.pada.learnproject.example.repository.ManyToOneRepository;
import com.pada.learnproject.example.service.dto.request.ManyToOneRequest;
import com.pada.learnproject.example.service.dto.response.ManyToOneResponse;
import com.pada.learnproject.example.service.mapper.ManyToOneMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManyToOneService {

    private final ExampleEntityRepository exampleEntityRepository;
    private final ManyToOneRepository manyToOneRepository;
    private final ManyToOneMapper manyToOneMapper;


    @Transactional
    public ManyToOneResponse addManyToOneToExample(Long id, ManyToOneRequest manyToOneRequest) {
        ExampleEntity exampleEntity = exampleEntityRepository.findById(id).orElseThrow(RuntimeException::new);
        ManyToOneEntity manyToOneEntity = manyToOneMapper.toEntity(manyToOneRequest);
        exampleEntity.addManyToOneEntity(manyToOneEntity);

        return null;
    }
}
