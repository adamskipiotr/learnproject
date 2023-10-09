package com.pada.learnproject.example.service;

import com.pada.learnproject.example.domain.ManyToManyEntity;
import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.service.dto.request.ManyToManyRequest;
import com.pada.learnproject.example.service.mapper.ManyToManyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManyToManyService {

    private final ManyToManyMapper manyToManyMapper;

    @Transactional
    public ManyToManyEntity createManyToManyEntity(ManyToManyRequest manyToManyRequest) {
        return manyToManyMapper.toEntity(manyToManyRequest);
    }
}
