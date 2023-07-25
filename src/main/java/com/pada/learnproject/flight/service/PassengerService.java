package com.pada.learnproject.flight.service;

import com.pada.learnproject.flight.domain.Passenger;
import com.pada.learnproject.flight.repository.PassengerRepository;
import com.pada.learnproject.flight.service.dto.PassengerListResponse;
import com.pada.learnproject.flight.service.dto.PassengerListWrapperResponse;
import com.pada.learnproject.flight.service.dto.PassengerRequest;
import com.pada.learnproject.flight.service.dto.PassengerResponse;
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
        Page<Passenger> flightPage = passengerRepository.findAll(passengerSpecification, pageable);
        List<PassengerListResponse> data = flightPage
            .stream()
            .map(passengerMapper::toListResponse)
            .toList();

        return new PassengerListWrapperResponse(data);
    }

    private Specification<Passenger> createSpecification(PassengerCriteria filter) {
        Specification<Passenger> specification = Specification.where(null);

        return specification;

    }

    @Transactional
    public PassengerResponse findById(Long id) {
        Passenger flight = passengerRepository.findById(id).orElseThrow(RuntimeException::new);
        return passengerMapper.toResponse(flight);
    }

    @Transactional
    public PassengerResponse addPassenger(PassengerRequest passengerRequest) {
        Passenger flight = passengerMapper.toEntity(passengerRequest);
        flight = passengerRepository.save(flight);
        return passengerMapper.toResponse(flight);
    }


    @Transactional
    public PassengerResponse updatePassenger(Long id, PassengerRequest passengerRequest) {
        Passenger flight = passengerRepository.findById(id).orElseThrow(RuntimeException::new);
        flight = passengerMapper.updateEntity(flight, passengerRequest);
        return passengerMapper.toResponse(flight);
    }

    @Transactional
    public PassengerResponse deletePassenger(Long id) {
        Passenger flight = passengerRepository.findById(id).orElseThrow(RuntimeException::new);
        passengerRepository.deleteById(id);
        return passengerMapper.toResponse(flight);
    }

}
