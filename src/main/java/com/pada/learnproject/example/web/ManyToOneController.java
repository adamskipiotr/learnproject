package com.pada.learnproject.example.web;

import com.pada.learnproject.example.service.ManyToOneService;
import com.pada.learnproject.example.service.dto.ManyToManyRequest;
import com.pada.learnproject.example.service.dto.ManyToOneRequest;
import com.pada.learnproject.example.service.dto.ManyToOneResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("many-to-ones")
@Tag(name = "ManyToOne Controller")
@RequiredArgsConstructor
public class ManyToOneController {

    private final ManyToOneService manyToOneService;

    @PostMapping("/{id}")
    public ManyToOneResponse addManyToOneToExample(@PathVariable(name = "id") Long id,
        @RequestBody ManyToOneRequest manyToOneRequest) {
        return manyToOneService.addManyToOneToExample(id, manyToOneRequest);
    }
}
