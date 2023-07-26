package com.pada.learnproject.flight.service;


import static com.pada.learnproject.flight.repository.CrewMemberRepository.Specs.byAgeFrom;
import static com.pada.learnproject.flight.repository.CrewMemberRepository.Specs.byNameLike;

import com.pada.learnproject.flight.domain.CrewMember;
import com.pada.learnproject.flight.domain.CrewMember_;
import com.pada.learnproject.flight.domain.criteria.CrewMemberCriteria;
import com.pada.learnproject.flight.repository.CrewMemberRepository;
import com.pada.learnproject.flight.service.dto.response.CrewMemberListResponse;
import com.pada.learnproject.flight.service.dto.response.CrewMemberListWrapperResponse;
import com.pada.learnproject.flight.service.dto.request.CrewMemberRequest;
import com.pada.learnproject.flight.service.dto.response.CrewMemberResponse;
import com.pada.learnproject.flight.service.mapper.CrewMemberMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CrewMemberService {

    private final CrewMemberRepository crewMemberRepository;
    private final CrewMemberMapper crewMemberMapper;


    @Transactional
    public CrewMemberListWrapperResponse findCrewMembers(Pageable pageable, CrewMemberCriteria crewMemberCriteria) {
        Specification<CrewMember> crewMemberSpecification = createSpecification(crewMemberCriteria);
        Page<CrewMember> crewMemberPage = crewMemberRepository.findAll(crewMemberSpecification, pageable);
        List<CrewMemberListResponse> data = crewMemberPage
            .stream()
            .map(crewMemberMapper::toListResponse)
            .toList();

        return new CrewMemberListWrapperResponse(data);
    }

    private Specification<CrewMember> createSpecification(CrewMemberCriteria filter) {
        Specification<CrewMember> specification = Specification.where(null);
        specification = byNameLike(specification, filter.getFirstName(), CrewMember_.firstName);
        specification = byNameLike(specification, filter.getLastName(), CrewMember_.lastName);
        specification = byAgeFrom(specification, filter.getAge());
        return specification;
    }

    @Transactional
    public CrewMemberResponse findById(Long id) {
        CrewMember crewMember = crewMemberRepository.findById(id).orElseThrow(RuntimeException::new);
        return crewMemberMapper.toResponse(crewMember);
    }

    @Transactional
    public CrewMemberResponse addCrewMember(CrewMemberRequest crewMemberRequest) {
        CrewMember crewMember = crewMemberMapper.toEntity(crewMemberRequest);
        crewMember = crewMemberRepository.save(crewMember);
        return crewMemberMapper.toResponse(crewMember);
    }


    @Transactional
    public CrewMemberResponse updateCrewMember(Long id, CrewMemberRequest crewMemberRequest) {
        CrewMember crewMember = crewMemberRepository.findById(id).orElseThrow(RuntimeException::new);
        crewMember = crewMemberMapper.updateEntity(crewMember, crewMemberRequest);
        return crewMemberMapper.toResponse(crewMember);
    }

    @Transactional
    public CrewMemberResponse deleteCrewMember(Long id) {
        CrewMember crewMember = crewMemberRepository.findById(id).orElseThrow(RuntimeException::new);
        crewMemberRepository.deleteById(id);
        return crewMemberMapper.toResponse(crewMember);
    }
}
