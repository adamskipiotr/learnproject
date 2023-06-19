package com.pada.learnproject.example.web;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.service.ExampleService;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import com.pada.learnproject.example.service.dto.ExampleResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("examples")
@Tag(name = "Example Controller")
@RequiredArgsConstructor
public class ExamplesController {

    private final ExampleService exampleEntityService;

    @GetMapping
    public ResponseEntity<List<ExampleListResponse>> getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        Page<ExampleListResponse> page =  exampleEntityService.getExamples(pageable, exampleCriteria);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/{id}")
    public ExampleResponse getExample(@PathVariable(name = "id") Long id) {
        return exampleEntityService.getExample(id);
    }

    @PostMapping
    public void addExample(@RequestBody ExampleRequest exampleRequest) {
        exampleEntityService.addExampleEntity(exampleRequest);
    }

    @PutMapping("/{id}")
    public void updateExample(@PathVariable(name = "id") Long id, @RequestBody ExampleRequest exampleRequest) {
        exampleEntityService.updateExampleEntity(exampleRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteExample(@PathVariable(name = "id") Long id) {
        exampleEntityService.deleteExample(id);
    }
}
