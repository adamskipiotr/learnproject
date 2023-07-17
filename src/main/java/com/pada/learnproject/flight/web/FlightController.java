package com.pada.learnproject.flight.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@Tag(name = "Flights Controller")
@RequiredArgsConstructor
public class FlightController {
}
