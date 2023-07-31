package com.pada.learnproject.flight.service;

import static com.pada.learnproject.flight.repository.TicketRepository.Specs.byPriceTo;
import static com.pada.learnproject.flight.repository.TicketRepository.Specs.byTicketClass;

import com.pada.learnproject.flight.domain.Ticket;
import com.pada.learnproject.flight.domain.Ticket_;
import com.pada.learnproject.flight.domain.criteria.TicketCriteria;
import com.pada.learnproject.flight.repository.TicketRepository;
import com.pada.learnproject.flight.service.command.UpdateTicketCommand;
import com.pada.learnproject.flight.service.dto.request.TicketRequest;
import com.pada.learnproject.flight.service.dto.response.TicketListResponse;
import com.pada.learnproject.flight.service.dto.response.TicketListWrapperResponse;
import com.pada.learnproject.flight.service.dto.response.TicketResponse;
import com.pada.learnproject.flight.service.mapper.TicketMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Transactional
    public TicketListWrapperResponse findTickets(Pageable pageable, TicketCriteria ticketCriteria) {
        Specification<Ticket> ticketSpecification = createSpecification(ticketCriteria);
        Page<Ticket> ticketPage = ticketRepository.findAll(ticketSpecification, pageable);
        List<TicketListResponse> data = mapTicketsToResponse(ticketPage);

        return new TicketListWrapperResponse(data);
    }

    private Specification<Ticket> createSpecification(TicketCriteria filter) {
        Specification<Ticket> specification = Specification.where(null);
        specification = byPriceTo(specification, filter.getBasePrice(), Ticket_.basePrice);
        specification = byPriceTo(specification, filter.getLuggageFee(), Ticket_.luggageFee);
        specification = byTicketClass(specification, filter.getTicketClass());
        return specification;
    }

    private List<TicketListResponse> mapTicketsToResponse(Page<Ticket> ticketPage) {
        return ticketPage
            .stream()
            .map(ticketMapper::toListResponse)
            .toList();
    }

    @Transactional
    public TicketResponse findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(RuntimeException::new);
        return ticketMapper.toResponse(ticket);
    }

    @Transactional
    public TicketResponse addTicket(TicketRequest ticketRequest) {
        Ticket ticket = ticketMapper.toEntity(ticketRequest);
        ticket = ticketRepository.save(ticket);
        return ticketMapper.toResponse(ticket);
    }

    @Transactional
    public TicketResponse updateTicket(UpdateTicketCommand updateTicketCommand) {
        Ticket ticket = ticketRepository.findById(updateTicketCommand.ticketId().value())
            .orElseThrow(RuntimeException::new);
        ticket = ticketMapper.updateEntity(ticket, updateTicketCommand.ticketRequest());
        return ticketMapper.toResponse(ticket);
    }

    @Transactional
    public TicketResponse deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(RuntimeException::new);
        ticketRepository.deleteById(id);
        return ticketMapper.toResponse(ticket);
    }

}
