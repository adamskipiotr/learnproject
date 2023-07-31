package com.pada.learnproject.example.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.service.ExampleService;
import com.pada.learnproject.example.service.dto.request.ExampleRequest;
import com.pada.learnproject.example.service.dto.request.ManyToOneRequest;
import com.pada.learnproject.example.service.dto.response.ExampleListWrapperResponse;
import com.pada.learnproject.example.service.dto.response.ExampleResponse;
import com.pada.learnproject.example.service.dto.response.ManyToOneResponse;
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
@RequestMapping("/examples")
@Tag(name = "Example Controller")
@RequiredArgsConstructor
public class ExamplesController {

    private final ExampleService exampleEntityService;

    @GetMapping
    public ResponseEntity<ExampleListWrapperResponse> getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        ExampleListWrapperResponse response = exampleEntityService.getExamples(pageable, exampleCriteria);
        return ResponseEntity.status(OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExampleResponse> getExample(@PathVariable(name = "id") Long id) {
        ExampleResponse response = exampleEntityService.getExample(id);
        return ResponseEntity.status(OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ExampleResponse> addExample(@RequestBody ExampleRequest exampleRequest) {
        ExampleResponse response = exampleEntityService.addExampleEntity(exampleRequest);
        return ResponseEntity.status(CREATED).body(response);
    }

    @PostMapping("/{exampleEntityId}/many-to-ones/{manyToOneId}")
    public ManyToOneResponse addManyToOneToExample(@PathVariable(name = "exampleEntityId") Long exampleEntityId,
        @PathVariable(name = "manyToOneId") Long manyToOneId, @RequestBody ManyToOneRequest manyToOneRequest) {
        // return manyToOneService.addManyToOneToExample(value, manyToOneRequest);
        //TODO to implement
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExampleResponse> updateExample(@PathVariable(name = "id") Long id,
        @RequestBody ExampleRequest exampleRequest) {
        ExampleResponse response = exampleEntityService.updateExampleEntity(exampleRequest, id);
        return ResponseEntity.status(OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExampleResponse> deleteExample(@PathVariable(name = "id") Long id) {
        ExampleResponse response = exampleEntityService.deleteExample(id);
        return ResponseEntity.status(OK).body(response);
    }
}
