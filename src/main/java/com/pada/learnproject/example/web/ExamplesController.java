package com.pada.learnproject.example.web;

import com.pada.learnproject.example.domain.ExampleCriteria;
import com.pada.learnproject.example.service.ExampleService;
import com.pada.learnproject.example.service.dto.ExampleListResponse;
import com.pada.learnproject.example.service.dto.ExampleRequest;
import com.pada.learnproject.example.service.dto.ExampleResponse;
import com.pada.learnproject.example.service.dto.OneToOneRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examples")
@Tag(name = "Example Controller")
public class ExamplesController {

    @Autowired
    private ExampleService exampleEntityService;

    @GetMapping
    public Page<ExampleListResponse> getExamples(Pageable pageable, ExampleCriteria exampleCriteria) {
        return exampleEntityService.getExamples(pageable, exampleCriteria);
    }

    @GetMapping("/{id}")
    public ExampleResponse getExample(@PathVariable(name = "id") Long id) {
        return exampleEntityService.getExample(id);
    }

    @PostMapping
    public void addExample(@RequestBody ExampleRequest exampleRequest) {
        exampleEntityService.addExampleEntity(exampleRequest);
    }
}
