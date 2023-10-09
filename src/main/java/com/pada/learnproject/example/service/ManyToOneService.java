package com.pada.learnproject.example.service;

import com.pada.learnproject.example.domain.ManyToOneEntity;
import com.pada.learnproject.example.service.dto.request.ManyToOneRequest;
import com.pada.learnproject.example.service.mapper.ManyToOneMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManyToOneService {

    private final ManyToOneMapper manyToOneMapper;


    @Transactional
    public ManyToOneEntity createManyToOneEntity(ManyToOneRequest manyToOneRequest) {
        return manyToOneMapper.toEntity(manyToOneRequest);
    }
}
