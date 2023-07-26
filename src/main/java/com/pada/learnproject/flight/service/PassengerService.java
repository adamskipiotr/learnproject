package com.pada.learnproject.flight.service;

import static com.pada.learnproject.flight.repository.PassengerRepository.Specs.byAgeFrom;
import static com.pada.learnproject.flight.repository.PassengerRepository.Specs.byIsPremium;
import static com.pada.learnproject.flight.repository.PassengerRepository.Specs.byNameLike;

import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.domain.Passenger_;
import com.pada.learnproject.flight.domain.criteria.PassengerCriteria;
import com.pada.learnproject.flight.repository.PassengerRepository;
import com.pada.learnproject.flight.service.dto.response.PassengerListResponse;
import com.pada.learnproject.flight.service.dto.response.PassengerListWrapperResponse;
import com.pada.learnproject.flight.service.dto.request.PassengerRequest;
import com.pada.learnproject.flight.service.dto.response.PassengerResponse;
import com.pada.learnproject.flight.service.mapper.PassengerMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    @Transactional
    public PassengerListWrapperResponse findPassengers(Pageable pageable, PassengerCriteria passengerCriteria) {
        Specification<Passenger> passengerSpecification = createSpecification(passengerCriteria);
        Page<Passenger> passengerPage = passengerRepository.findAll(passengerSpecification, pageable);
        List<PassengerListResponse> data = passengerPage
            .stream()
            .map(passengerMapper::toListResponse)
            .toList();

        return new PassengerListWrapperResponse(data);
    }

    private Specification<Passenger> createSpecification(PassengerCriteria filter) {
        Specification<Passenger> specification = Specification.where(null);
        specification = byNameLike(specification, filter.getFirstName(), Passenger_.firstName);
        specification = byNameLike(specification, filter.getLastName(), Passenger_.lastName);
        specification = byAgeFrom(specification, filter.getAge());
        specification = byIsPremium(specification, filter.getIsPremium());
        return specification;

    }

    @Transactional
    public PassengerResponse findById(Long id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(RuntimeException::new);
        return passengerMapper.toResponse(passenger);
    }

    @Transactional
    public PassengerResponse addPassenger(PassengerRequest passengerRequest) {
        Passenger passenger = passengerMapper.toEntity(passengerRequest);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toResponse(passenger);
    }


    @Transactional
    public PassengerResponse updatePassenger(Long id, PassengerRequest passengerRequest) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(RuntimeException::new);
        passenger = passengerMapper.updateEntity(passenger, passengerRequest);
        return passengerMapper.toResponse(passenger);
    }

    @Transactional
    public PassengerResponse deletePassenger(Long id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(RuntimeException::new);
        passengerRepository.deleteById(id);
        return passengerMapper.toResponse(passenger);
    }

}
