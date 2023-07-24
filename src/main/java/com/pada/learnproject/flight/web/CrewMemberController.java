package com.pada.learnproject.flight.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pada.learnproject.flight.service.CrewMemberCriteria;
import com.pada.learnproject.flight.service.CrewMemberService;
import com.pada.learnproject.flight.service.dto.CrewMemberListWrapperResponse;
import com.pada.learnproject.flight.service.dto.CrewMemberRequest;
import com.pada.learnproject.flight.service.dto.CrewMemberResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crew-members")
@Tag(name = "Crew Members Controller")
@RequiredArgsConstructor
public class CrewMemberController {

    private final CrewMemberService crewMemberService;

    @GetMapping
    public ResponseEntity<CrewMemberListWrapperResponse> getCrewMembers(Pageable pageable, CrewMemberCriteria flightCriteria) {
        var responseBody = crewMemberService.findCrewMembers(pageable, flightCriteria);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewMemberResponse> getCrewMemberById(@PathVariable(name = "id") Long id) {
        var responseBody = crewMemberService.findById(id);
        return ResponseEntity.status(OK).body(responseBody);
    }

    @PostMapping
    public ResponseEntity<CrewMemberResponse> addCrewMember(@RequestBody CrewMemberRequest flightRequest) {
        var responseBody = crewMemberService.addCrewMember(flightRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrewMemberResponse> updateCrewMember(@PathVariable(name = "id") Long id,
        @RequestBody CrewMemberRequest flightRequest) {
        var responseBody = crewMemberService.updateCrewMember(id, flightRequest);
        return ResponseEntity.status(CREATED).body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CrewMemberResponse> deleteCrewMember(@PathVariable(name = "id") Long id) {
        var responseBody = crewMemberService.deleteCrewMember(id);
        return ResponseEntity.status(OK).body(responseBody);
    }
}
